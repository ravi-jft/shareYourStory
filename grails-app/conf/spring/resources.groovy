import bruteForce.AuthenticationFailureListener
import bruteForce.AuthenticationSuccessEventListener

// Place your Spring DSL code here
beans = {
    userDetailsService(loginWithMail.UserDetail)

    authenticationFailureListener(AuthenticationFailureListener) {
        loginAttemptCacheService = ref('loginAttemptCacheService')
    }

    authenticationSuccessEventListener(AuthenticationSuccessEventListener) {
        loginAttemptCacheService = ref('loginAttemptCacheService')
    }

    }
