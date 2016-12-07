package loginWithMail.user

import grails.transaction.Transactional

import org.codehaus.groovy.ast.expr.PostfixExpression
import loginWithMail.User


@Transactional
class EnableUserService {
    def Enable(User user) {               //enable the user on clicking activation link
        user.enabled = true
        user.token = null
        user.save(flush: true)
        return user
    }

}