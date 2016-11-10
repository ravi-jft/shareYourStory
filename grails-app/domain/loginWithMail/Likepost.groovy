package loginWithMail

import spock.util.mop.Use

class Likepost {
    User user
    static belongsTo = [post:Post]
    static constraints = {
    }
}
