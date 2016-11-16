package loginWithMail

import grails.validation.Validateable

/**
 * Created by ravi on 27/10/16.
 */
@Validateable
class checkPasswordCommand {
    String firstname
    String lastname
    String email
    String contact
    String address
    String username
    String password
    String conformpassword

    static constraints = {
        firstname blank: false
        lastname nullable: true
        email blank: false, email: true
        contact nullable: true
        address nullable: true
        username blank: false
        conformpassword (nullable: false,
                validator:{passwd2,obj->
                    return passwd2 == obj.password
                })
    }
}
