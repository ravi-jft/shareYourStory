package loginWithMail

class NavMenu  {
   User admin
    String category
   // int rank = 0
   // Boolean active = false

    SortedSet subItems
    static hasMany = [subItems: NavMenu,products:Product]
    static belongsTo = [parent: NavMenu]

    static constraints = {
        category blank: false
        products nullable: true
        parent nullable: true
    }

   // static mapWith = "none"

/*    @Override
    public String toString() {
        return "NavMenu{" +
                ", parent=" + parent +
                '}';
    }*/
}
