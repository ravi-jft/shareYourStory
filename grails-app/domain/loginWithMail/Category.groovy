package loginWithMail

class Category {
    String name
    //User admin

    static hasMany = [subCategory:SubCategory,products:Product]
    static constraints = {
        name blank: false
    }
    static mapWith = "none"

}
