package loginWithMail

class NavMenu  {
   User admin
    String category

    //SortedSet subItems
    static hasMany = [subItems: NavMenu,products:Product]
    static belongsTo = [parent: NavMenu]

    static constraints = {
        category blank: false
        products nullable: true
        parent nullable: true
    }
}
