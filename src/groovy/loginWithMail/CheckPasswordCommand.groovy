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
        firstname blank: false, size: 3..15
        lastname nullable: true, size: 3..15
        email blank: false, email: true
        contact nullable: true, maxSize:10, minSize: 10
        address nullable: true, size: 20..100
        username blank: false
        password size: 4..25
        conformpassword (nullable: false,
                validator:{passwd2,obj->
                    return passwd2 == obj.password
                })
    }
}
