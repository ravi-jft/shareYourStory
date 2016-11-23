package loginWithMail.user

import grails.transaction.Transactional

import org.codehaus.groovy.ast.expr.PostfixExpression
import loginWithMail.User


@Transactional
class EnableUserService {
    User Enable(String token) {                   //enable the user on clicking activation link
        User user = User.findByToken(token)
        if (user) {
            user.enabled = true
            user.token = null
                user.save(flush: true)
                return user
        }
    }

}
