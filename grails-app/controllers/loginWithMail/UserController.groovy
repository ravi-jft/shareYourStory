package loginWithMail

import grails.plugin.springsecurity.annotation.Secured
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import org.fusesource.jansi.AnsiRenderer
import org.springframework.security.crypto.bcrypt.BCrypt
import groovy.time.*
import java.util.UUID
//import org.codehaus.groovy.runtime.TimeCategory

//@Transactional(readOnly = true)
@Secured(['permitAll'])
class UserController {
   def mailService
    def springSecurityService

    def enableUserService
    def sendALinkService
    def checkUrlService
    def resetCommitService
    def userRegisterService
    def unlockAccountService


    LinkGenerator grailsLinkGenerator

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static defaultAction = "register"
    def login(){}

    def register(CheckPasswordCommand cpc){
        if (request.method == "POST"){
            if (cpc.validate()){
                def user = userRegisterService.submit(cpc)
                if (user){
                    flash.messageLink = (message(code: 'password.reset.passwordForget'))
                    redirect(controller: 'logout')
                    }
            }else {
                //flash.message = "Error Registering User"
                return [user: cpc]
            }
        }
    }




   /* def checkEmail(){
        println "------------params-----"+params.email
        List<User> users = User.findAllByEmail(params.email)
        println "----users------------"+users*.email*/


        //redirect("Hello This is return")
 /*   def checkEmail() {      //checkEmail for Ajax
        def users = User.findAll()

            List email = users.email
            for (int i=0;i<email.size();i++)
            render (email.get(i));
            //render (email)
    }*/

    def checkEmail(){
    User user = User.findByEmail(params.email)
        if(user) {
            render (message(code:'email.exist'))
        }
    }

    def enableUser(String token){
           def user = enableUserService.Enable(token)
            if (user) {
                render(message(code: 'account.activate'))
            }
            else {
                render(message(code:'url.invalid'))
            }
    }

    //Forget Password
    def forgetPassword(){}

    def sendALink(String username,String token){
        if (params.username) {
            def user = sendALinkService.createLink(username, token)
            if (user) {
                String email = user.email
                token = user.token
                println("===================token in sendALink=====" + user.token)
                sendMail {
                    multipart true
                    to email
                    subject "Change your Password"
                    String url = grailsLinkGenerator.link(controller: 'user', action: 'checkUrl', absolute: true, params: [token: token])
                    body url
                    render(message(code: 'password.reset.passwordForget'))
                }
            }
            else {
                flash.message = message(code: 'user.invalid')
                render(view: 'forgetPassword')
            }
        }
        else {
            flash.error = message(code: 'textField.blank')
            render(view: 'forgetPassword')
        }
    }

    def checkUrl(){  //it will check for valid link sent at email
        String token = params.token

        println "=============================================token:"+params.token
        User user=User.findByToken(token)
        if(user) {
            use (TimeCategory) {
            if((new Date()- user.linkcreateDate ) <= 5.minutes) {
                redirect(action: 'resetPassword', params: [token: token])
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

  /*  def checkUrl(token){
        checkUrlService.checkurl(token)
        redirect(action: 'resetPassword', params: [token: token])

    }*/

    def resetPassword(){ //here we will enter new password
        // println "==============================================================="+getParams()
    }

    def resetCommit(ResetPasswordCommand checkPassword){
        println params
        if (checkPassword.validate()){
            def user = resetCommitService.reset(checkPassword)
            if (user)
            render (message(code: 'password.forget.controller'))
        }
        else {
            flash.error = (message(code: 'password.unmatched.passwordForget'))
            render (view: 'resetPassword')
        }
    }


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

/*    def unlockAccountLink(){
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

    }*/

    def unlockAccountLink(String loginUser){
        def user
        if (params.loginUser == ""){
            flash.error = (message(code: 'textField.blank'))
            render(view: 'unlockaccount')
        }else {
        user = unlockAccountService.unlock(loginUser)}
        if (user){
            render (message(code: 'password.reset.passwordForget'))
        }
        else {
            render (message(code: 'user.invalid'))
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
        user.save(flush: true)
        render("your account is successfully unlocked")
    }


}



