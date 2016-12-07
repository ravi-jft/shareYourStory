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
    def userRegisterService
    def enableUserService
    def sendALinkService
    def checkUrlService

   /* static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]*/
    static defaultAction = "register"


    def index(){
        def product = Product.list()
        [product:product]
    }

    def login(){}

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def home(){
        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')) {
            redirect controller: 'user', action: 'adminHome'
        }
        if (SpringSecurityUtils.ifAllGranted('ROLE_USER')) {
            redirect controller: 'user', action: 'userHome'
        }
    }

    @Secured(['ROLE_ADMIN'])
    def adminHome(){
        def navmenu = NavMenu.list()
        def product = Product.list()
        [navmenu:navmenu,product: product]
    }

    @Secured(['ROLE_USER'])
    def userHome(){
        def product = Product.list()
        println("==========in userHOme.............=="+product)
        [product:product]
    }

    def register(CheckPasswordCommand cpc,User user) {

        if (request.method == "POST") {
            user = new User(cpc.properties)
            if (user.validate()) {
                try {
                    def userService = userRegisterService.submit(cpc,user)
                    if (userService){
                        render(message(code: 'default.confirm.account'))
                    }
                }
                catch (Exception e){
                    flash.checkNet=message(code:'default.check.net')
                    render(view: 'register')
                }

            } else {
                render (view: 'register', model: [user: cpc])
            }
        }
    }


    def checkUsername() {   //check Username with Ajax
        def user = User.findByUsername(params.username)
        render(user.username)
    }

    def checkEmail() {   //check Email with Ajax
        def user = User.findByEmail(params.email)
        render(user.email)
    }

    def enableUser(User user) {  //enable the user on clicking activation link
       String token = params.token
        user = User.findByToken(token)
        if (user){
        def userService = enableUserService.Enable(user)
            if (userService) {
            flash.message = (message(code: 'account.activate'))
            redirect(controller: 'login', action: 'auth')
            }
        }
        else {
            render(message(code: 'url.invalid'))
        }
    }

    //Forget Password
    def forgetPassword(){}

    //@Secured(['ROLE_ADMIN','ROLE_USER'])
    def sendALink(User user ){   ///By this we will sent a reset link at email
        user= User.findByUsername(params.username)
        if(!user) {
            flash.message = message(code: 'default.user.notFound')
            render(view: 'forgetPassword')
        }
        else {
            try {
                def userService= sendALinkService.createLink(user)
                if (userService){
                    render(message(code: 'password.reset.passwordForget'))
                }
            }
            catch (Exception e){
                flash.checkNet=message(code:'default.check.net')
                render(view: 'forgetPassword')
            }

        }
    }

    //@Secured(['ROLE_ADMIN','ROLE_USER'])
    def checkUrl(User user){  //it will check for valid link sent at email
        String token = params.token
        user=User.findByToken(token)
        if(user) {
            def userService= checkUrlService.checkurl(user)
            if(userService) {
                redirect(action: 'resetPassword', params: [token: token])
            }
            else {
                render("timeOut")
            }
        }
        else {
            render (message(code: 'url.link.invalid'))
        }
    }

    //@Secured(['ROLE_ADMIN','ROLE_USER'])
    def resetPassword(){ //here we will enter new password
    }

    //@Secured(['ROLE_ADMIN','ROLE_USER'])
    def resetCommit() {
        if(params.token=='' || params.password=='' || params.confirmpassword==''){
            flash.message = message(code: 'default.label.blank')
            render(view: 'resetPassword')
        }
        else {
            User user = User.findByToken(params.token)
            user.password = params.password
            if (user.password == params.confirmpassword) {
                user.token = null
                user.linkcreateDate = null
                user.save(flush: true)
                flash.message = message(code: 'password.forget.controller')
                redirect(controller: 'login', action: 'auth')
            } else {
                flash.error = (message(code: 'password.unmatched.passwordForget'))
                render(view: 'resetPassword')
            }
        }
    }

    //update password

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def updatePassword(){}

    def update() {
        if(params.password=='' || params.newPassword=='' || params.confirmNewPassword==''){
            flash.blank = message(code: 'default.label.blank')
            render(view: 'updatePassword')
        }
        else {
            User user = springSecurityService.getCurrentUser()
            if (BCrypt.checkpw(params.password, user.password)) {
                if (params.newPassword == params.confirmNewPassword) {
                    user.password = params.newPassword
                    user.save(flush: true)
                    flash.message = message(code:'login.again')
                    redirect(controller: 'login', action: 'auth')
                } else {
                    flash.error = (message(code: 'password.unmatched.passwordForget'))
                    render(view: 'updatePassword')
                }

            } else {
                flash.message = (message(code: 'password.old.update'))
                render(view: 'updatePassword')
            }
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

        if (params.loginUser==''){
            flash.blank= message(code: 'default.label.blank')
            render(view: 'unlockaccount')
        }
        else {
            def user = User.findByUsername(params.loginUser)
            if (user) {
                mail = user.email
                user.token = token
                user.linkcreateDate = new Date()
                //user.accountLocked=true
                user.save(flush: true, failOnError: true)
            }
/*
        else if (!user){
            def user1 =User.findByEmail(params.loginUser)
            mail = user1.email
            user1.token = token
            user1.linkcreateDate=new Date()
            user1.save(flush: true, failOnError: true)
        }*/
            else {
                flash.message = message(code: 'default.invalid.user')
                render(view: 'unlockaccount')
            }
            try {
                sendMail {
                    multipart true
                    to mail
                    subject "Unlock Your Account"
                    String url = grailsLinkGenerator.link(controller: 'user', action: 'unlockCheckUrl', absolute: true, params: [token: token])
                    body url
                    render(message(code: 'password.reset.passwordForget'))
                }
            }
            catch (Exception e){
                flash.checkNet=message(code:'default.check.net')
                render(view: 'unlockaccount')
            }

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
       // render("your account is successfully unlocked")
        flash.message="default.account.unlocked"
        redirect(controller: 'login', action: 'auth')
    }


}



