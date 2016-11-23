package loginWithMail.user

import grails.transaction.Transactional
import loginWithMail.User
import loginWithMail.ResetPasswordCommand

class UserException extends RuntimeException{
    String message
    String code
}

@Transactional
class ResetCommitService {

    def reset(ResetPasswordCommand checkPassword) {
     User user = User.findByToken(checkPassword.token)
        println("=====================ResetCommitService======"+user)
            user.token=null
            user.save(failOnError: true)
            return user
        }
}

