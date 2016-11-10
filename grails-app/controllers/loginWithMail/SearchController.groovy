package loginWithMail

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class SearchController {
    static defaultAction = "search"
    def springSecurityService
    def searchableService
    def index() {}

 /*   def search() {
        def query = params.q
        if (!query) {
            return [:]
        }
        try {
            def searchResult = Post.search(query, params)
            return [searchResult: searchResult]
        } catch (e) {
            return [searchError: true]
        }
    }*/
 /*   def searchresult(){
        def query = params.q
        User user=springSecurityService.getCurrentUser()
        if (!query) {
            return [:]
        }
        try {
            def searchResult = Post.search(query,params)
            return [searchResult: searchResult,user:user]
        } catch (e) {
            return [searchError: true]
        }
    }*/
}
