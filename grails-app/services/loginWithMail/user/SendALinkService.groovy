package loginWithMail.user

import grails.transaction.Transactional
import loginWithMail.User

@Transactional
class SendALinkService {

    def grailsLinkGenerator

    User createLink(User user) {
        UUID token = UUID.randomUUID()
        String email = user.email
        user.token = token
        user.linkcreateDate = new Date()
        user.save(flush: true, failOnError: true)


        try {
            sendMail {
                multipart true
                to email
                subject "Change your Password"
                String url = grailsLinkGenerator.link(controller: 'user', action: 'checkUrl', absolute: true, params: [token: token])
                body url
            }
            return user
        }
        catch (Exception e){
            throw e
        }
    }
}