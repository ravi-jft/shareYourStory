package loginWithMail

class SubCategory {
    String name
    Category category

    static belongsTo = [Category,SubCategory]

    static hasMany = [child:SubCategory]
    static constraints = {
    }
    static mapWith = "none"
}
