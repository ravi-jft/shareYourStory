//package loginWithMail

import spock.util.mop.Use

class Attempt {
    User user
    static belongsTo = [post:Post]
    static constraints = {
    }
}
