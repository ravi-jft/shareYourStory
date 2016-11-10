package loginWithMail

class Post {
    String content
    Date dateCreated

    static belongsTo = [user:User]
    static hasMany = [likes:Likepost]

    static searchable = true

    static constraints = {
        content blank: false
    }
    static mapping = {
        sort dateCreated:"desc"
    }
}
