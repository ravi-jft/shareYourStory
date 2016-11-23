package loginWithMail

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import org.springframework.security.crypto.bcrypt.BCrypt
import groovy.time.*
//import org.codehaus.groovy.runtime.TimeCategory

//@Transactional(readOnly = true)
@Secured(['permitAll'])
class UserController {
    def mailService
    def springSecurityService
    LinkGenerator grailsLinkGenerator

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static defaultAction = "register"
    def login(){}

    def home(){
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')) {
            redirect controller: 'user', action: 'adminHome'
           // return
        }
        if (SpringSecurityUtils.ifAllGranted('ROLE_USER')) {
            redirect controller: 'user', action: 'userHome'
           // return
        }
    }

    def adminHome(){
        def navmenu = NavMenu.list()
        [navmenu:navmenu]
    }

    def userHome(){}

    def register(CheckPasswordCommand cpc) {

        if (request.method == "POST") {
           /* if (cpc.hasErrors()) {
                return [myerrors: cpc]
            } else {*/
                User user = new User(cpc.properties)
                String mail = params.email
                UUID token = UUID.randomUUID()
                user.token = token
                if (user.validate()) {
                    user.save(flush: true, failOnError: true)
                   Role role = Role.findByAuthority("ROLE_USER")
                    /*Role role = Role.findByAuthority("ROLE_ADMIN")*/
                    new UserRole(user, role).save(flush: true, failOnError: true)
                    //render(message(code: 'data.save'))
                    flash.message=(message(code: 'data.save'))
                } else {
                    flash.message = "Error Registering User"
                    return [ user: cpc ]
              }
            sendMail {
                multipart true
                to mail
                subject "activation link"
                String url = grailsLinkGenerator.link(controller: 'user', action: 'enableUser', absolute: true, params: [token: token])
                body url
                //render(message(code: 'password.reset.passwordForget'))
                flash.messageLink=(message(code: 'password.reset.passwordForget'))
                redirect(controller: 'logout')
            }
        }
    }

    def checkEmail() {
        def users = User.findAll()
            List<User> email = users.email
            render (email.get(0));
    }

    def enableUser() {  //enable the user on clicking activation link
        String tokenUrl = params.token
        User user = User.findByToken(tokenUrl)
        if (user) {
            user.enabled = true
            user.token = null
            user.save(flush: true)
            render (message(code: 'account.activate'))
           // flash.message = (message(code: 'account.activate'))
            //will redirect to homepage
        } else {
            render(message(code: 'url.invalid'))
        }
    }


    //Forget Password
    def forgetPassword(){}

    def sendALink(){   ///By this we will sent a reset link at email
        String mail
        String token=UUID.randomUUID()
        println("============================token========"+token)
        def user= User.findByUsername(params.loginUser)
        if (!user){
            def user1 =User.findByEmail(params.loginUser)
            mail = user1.email
            user1.token = token
            user1.linkcreateDate=new Date()
            user1.save(flush: true, failOnError: true)
        }else {
            mail = user.email
            user.token = token
            user.linkcreateDate=new Date()
            user.save(flush: true, failOnError: true)
        }

        sendMail{
            multipart true
            to mail
            subject "Change your Password"
            String url =  grailsLinkGenerator.link(controller: 'user', action: 'checkUrl',absolute: true,params: [token:token])
            body url
            render (message(code: 'password.reset.passwordForget'))
        }
    }
    def checkUrl(){  //it will check for valid link sent at email
        String tokenUrl = params.token
        println(params.token)
        /*println "===========token:"+tokenUrl*/
        User user=User.findByToken(tokenUrl)
        if(user) {
            use (TimeCategory) {
            if((new Date()- user.linkcreateDate ) <= 5.minutes) {
                redirect(action: 'resetPassword', params: [tokenUrl: tokenUrl])
            }
            else {
                render("timeOut")
            }
            }
            }
        else {
            render (message(code: 'url.link.invalid'))
        }
    }
    def resetPassword(){ //here we will enter new password
        // println "==============================================================="+getParams()
    }

    def resetCommit() {
       User user = User.findByToken(params.tokenUrl)
        user.password = params.password
        if (user.password == params.confirmpassword) {
            user.token = null
            user.linkcreateDate=null
            user.save(flush: true)
            // render("password changed successfully")
            render (message(code: 'password.forget.controller'))
        }
        else {
            // flash.message = "password is not matched"
            //redirect(controller: 'passwordForget' ,action: 'resetPassword')
            flash.error = (message(code: 'password.unmatched.passwordForget'))
            render (view: 'resetPassword')
        }
    }

    //update password

    def updatePassword(){}

    def update() {
        User user = springSecurityService.getCurrentUser()
        if (BCrypt.checkpw(params.password, user.password)) {
            if (params.newPassword == params.confirmNewPassword){
                user.password=params.newPassword
                user.save(flush: true)
                render (message(code: 'password.forget.controller'))
            }
            else {
                flash.error=(message(code: 'password.unmatched.passwordForget'))
                render(view: 'updatePassword')
            }

        } else {
            flash.message= (message(code: 'password.old.update'))
            render(view: 'updatePassword')
        }


    }

    //edit the view
     def edit(){
         User user=springSecurityService.getCurrentUser()
         [user: user]
     }
    def updateInfo(){
        User user=springSecurityService.getCurrentUser()
        user.firstname=params.firstname
        user.lastname=params.lastname
        user.contact=params.contact
        user.address=params.address
        user.save(flush:true, failOnError: true)
        render "successfully updated"

    }

    //view your profile
    def show(){
        User user=springSecurityService.getCurrentUser()
        [user: user]
    }



    //unlock account if its locked by anyone by sending a link to mail
    def unlockaccount(){}

    def unlockAccountLink(){
        String mail
        String token=UUID.randomUUID()
        println("============================token========"+token)
        def user= User.findByUsername(params.loginUser)
        if (!user){
            def user1 =User.findByEmail(params.loginUser)
            mail = user1.email
            user1.token = token
            user1.linkcreateDate=new Date()
            user1.save(flush: true, failOnError: true)
        }else {
            mail = user.email
            user.token = token
            user.linkcreateDate=new Date()
            //user.accountLocked=true
            user.save(flush: true, failOnError: true)
        }

        sendMail{
            multipart true
            to mail
            subject "Unlock Your Account"
            String url =  grailsLinkGenerator.link(controller: 'user', action: 'unlockCheckUrl',absolute: true,params: [token:token])
            body url
            render (message(code: 'password.reset.passwordForget'))
        }

    }

    def unlockCheckUrl(){  //it will check for valid link sent at email for unlocking account
        String tokenUrl = params.token
        println(params.token)
        User user=User.findByToken(tokenUrl)
        if(user) {
            use (TimeCategory) {
                if((new Date()- user.linkcreateDate ) <= 5.minutes) {
                    redirect(action: 'resetAccount', params: [tokenUrl: tokenUrl])
                }
                else {
                    render("timeOut")
                }
            }
        }
        else {
            render (message(code: 'url.link.invalid'))
        }
    }
    def resetAccount(){ //here we will enter new password
        User user = User.findByToken(params.tokenUrl)
        println("=============================resetAccount======"+user)
        user.accountLocked=false
        user.attempts=0
        user.save(flush: true)
        render("your account is successfully unlocked")
    }


}



