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
            loginAttemptCacheService.failLogin(e.authentication.name)
        }
    }

  /*  public void onApplicationEvent(ApplicationEvent appEvent)
    {
        if (appEvent instanceof AuthenticationSuccessEvent)
        {
            AuthenticationSuccessEvent event = (AuthenticationSuccessEvent) appEvent;
            UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();

            // ....
        }
    }*/

