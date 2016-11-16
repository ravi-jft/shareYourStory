package loginWithMail

import grails.validation.Validateable

/**
 * Created by ravi on 14/11/16.
 */
@Validateable
class ResetPasswordCommand {
    String password
    String confirmpassword
    String token

    static constraints = {
        confirmpassword (nullable: false,
                validator:{passwd2,obj->
                    return passwd2 == obj.password
                })
    }

    @Override
    public String toString() {
        return "ResetPasswordCommand{" +
                "password='" + password + '\'' +
                ", confirmpassword='" + confirmpassword + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
