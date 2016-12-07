package loginWithMail.user

import grails.transaction.Transactional
import loginWithMail.CheckPasswordCommand
import loginWithMail.Role
import loginWithMail.User
import loginWithMail.UserRole

@Transactional
class UserRegisterService {
    def grailsLinkGenerator

    def submit(CheckPasswordCommand cpc,User user) {
        String email = cpc.email
        UUID token = UUID.randomUUID()
        user.token = token

        user.save(flush: true, failOnError: true)
        Role role = Role.findByAuthority("ROLE_USER")
        new UserRole(user, role).save(flush: true, failOnError: true)

        try {
            sendMail {
                multipart true
                to email
                subject "activation link"
                String url = grailsLinkGenerator.link(controller: 'user', action: 'enableUser', absolute: true, params: [token: user.token])
                body url
                return user
            }
        }
        catch (Exception e){
            //println("===========in service======"+e)
            throw e

        }
    }
}