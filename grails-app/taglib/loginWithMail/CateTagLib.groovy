package loginWithMail

class CateTagLib {
    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def printlist = { attrs, body ->
        def menu = attrs.menu
        menu?.each{list,i ->
            if (i.parentId == null){
                 out << '<li><a href="">' + String.valueOf(i.category) + '</a></li>'
            }
                menu?.each { list1, j ->
                    if (i.id == j.parentId) {
                        out << ' <ul><a href="">' + String.valueOf(j.category) + '</a></ul>'
                        i = j
                    }
                }
        }

    }

}
