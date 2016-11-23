package loginWithMail.user

import grails.transaction.Transactional
import loginWithMail.User

@Transactional
class SendALinkService {

    User createLink(String username,String token){
       token=UUID.randomUUID()
        def user= User.findByUsername(username)
        println("===================in sendAlink service"+token)
            user.token = token
            user.linkcreateDate=new Date()
            user.save(flush: true, failOnError: true)
        return user
    }
}
