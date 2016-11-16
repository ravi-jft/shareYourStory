package bruteForce

import loginWithMail.LoginAttemptCacheService
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent
import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import org.springframework.security.core.userdetails.UserDetails

    class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

        LoginAttemptCacheService loginAttemptCacheService

        void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
println("==============================="+e.authentication.name)
            loginAttemptCacheService.failLogin(e.authentication.name)
        }
    }


