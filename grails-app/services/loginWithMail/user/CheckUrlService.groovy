package loginWithMail.user

import grails.transaction.Transactional
import groovy.time.TimeCategory
import loginWithMail.User

@Transactional
class CheckUrlService {
    def messageSource

    User checkurl(String token){
        User user=User.findByToken(token)
        if(user) {
            use (TimeCategory) {
                if((new Date()- user.linkcreateDate ) <= 5.minutes) {
                    return user
                   // redirect(action: 'resetPassword', params: [token: token])
                }
                else {
                    render("timeOut")
                }
            }
        }
        else {
            //render (message(code: 'url.link.invalid'))
            messageSource.getMessage('url.link.invalid',request.getLocale())
        }

    }
}
