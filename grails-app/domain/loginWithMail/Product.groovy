package loginWithMail

class Product {
    String name
    String details
    Integer price
    Integer unit
    String productImage
    //Cart cartInstance

    static belongsTo = [category:NavMenu]
    static constraints = {
        name blank: false, minSize: 3, maxSize: 15,matches: /^\p{L}+(?: \p{L}+)*$/
        details blank: false, minSize: 3, maxSize: 50
        price nullable: false,range: 1..1000000
        category nullable: false
        productImage nullable: true
    }

}
