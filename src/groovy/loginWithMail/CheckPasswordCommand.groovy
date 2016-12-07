package loginWithMail

import grails.validation.Validateable

/**
 * Created by ravi on 27/10/16.
 */
@Validateable
class CheckPasswordCommand {
    String firstname
    String lastname
    String email
    Integer contact
    String address
    String username
    String password
    String conformpassword

    static constraints = {
        firstname blank: false
        lastname nullable: true
        email blank: false, email: true
        contact nullable: true,range: 10..10
        address nullable: true
        username blank: false
        conformpassword (nullable: false,
                validator:{passwd2,obj->
                    return passwd2 == obj.password
                })
    }
}
