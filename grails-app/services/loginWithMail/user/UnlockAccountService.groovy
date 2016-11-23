package loginWithMail.user

import grails.transaction.Transactional
import loginWithMail.User

@Transactional
class UnlockAccountService {
    def grailsLinkGenerator
    def unlock(String loginUser){
        String mail
        String token=UUID.randomUUID()
        def user= User.findByUsername(loginUser)
            mail = user.email
            user.token = token
            user.linkcreateDate=new Date()
            //user.accountLocked=true
            user.save(flush: true, failOnError: true)

        sendMail{
            multipart true
            to mail
            subject "Unlock Your Account"
            String url =  grailsLinkGenerator.link(controller: 'user', action: 'unlockCheckUrl',absolute: true,params: [token:token])
            body url
        }
    }
}
