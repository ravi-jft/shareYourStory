package loginWithMail.user

import grails.transaction.Transactional
import groovy.time.TimeCategory
import loginWithMail.User

@Transactional
class CheckUrlService {
    User checkurl(User user) {
        use(TimeCategory) {
            if ((new Date() - user.linkcreateDate) <= 5.minutes) {
                return user
            }

        }
    }
}
