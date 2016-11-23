package loginWithMail.user

import grails.transaction.Transactional
import loginWithMail.CheckPasswordCommand
import loginWithMail.Role
import loginWithMail.User
import loginWithMail.UserRole

@Transactional
class UserRegisterService {
    def grailsLinkGenerator

    def submit(CheckPasswordCommand cpc) {
        User user = new User(cpc.properties)
        String mail = cpc.email
        UUID token = UUID.randomUUID()
        user.token = token

        user.save(flush: true, failOnError: true)
        Role role = Role.findByAuthority("ROLE_ADMIN")
        new UserRole(user, role).save(flush: true, failOnError: true)

        sendMail {
            multipart true
            to mail
            subject "activation link"
            String url = grailsLinkGenerator.link(controller: 'user', action: 'enableUser', absolute: true, params: [token: user.token])
            body url
            return user
        }
    }
}