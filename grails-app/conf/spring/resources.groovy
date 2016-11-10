import bruteForce.AuthenticationFailureListener
import bruteForce.AuthenticationSuccessEventListener
import loginWithMail.CustomUserDetailsService

// Place your Spring DSL code here
beans = {
    userDetailsService(CustomUserDetailsService)

    authenticationFailureListener(AuthenticationFailureListener) {
        loginAttemptCacheService = ref('loginAttemptCacheService')
    }

    authenticationSuccessEventListener(AuthenticationSuccessEventListener) {
        loginAttemptCacheService = ref('loginAttemptCacheService')
    }

    }
