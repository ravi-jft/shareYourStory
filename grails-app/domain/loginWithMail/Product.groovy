package loginWithMail

class Product {
    String name
    String details
    Integer price
    //static belongsTo = [category:Category]
    static belongsTo = [category:NavMenu]
    static constraints = {
        name blank: false
        details blank: false
        price nullable: true
    }

}
