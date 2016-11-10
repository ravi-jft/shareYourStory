package bruteForce

import loginWithMail.LoginAttemptCacheService
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AuthenticationSuccessEvent

/**
 * Created by ravi on 9/11/16.
 */


class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    LoginAttemptCacheService loginAttemptCacheService

    void onApplicationEvent(AuthenticationSuccessEvent e) {
        loginAttemptCacheService.loginSuccess(e.authentication.name)
    }
}
/*class AuthenticationSuccessEventListener implements ApplicationListener{

    LoginAttemptCacheService loginAttemptCacheService

    //@Override
    void onApplicationEvent(ApplicationEvent e) {
       // loginAttemptCacheService.failLogin(e)
        println("===================Success wala================lslslsflslldfls")
    }
}*/
