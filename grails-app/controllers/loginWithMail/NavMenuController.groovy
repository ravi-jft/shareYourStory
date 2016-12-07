package loginWithMail

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

//@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class NavMenuController {
    static defaultAction = "createCategory"

    def springSecurityService

    def createCategory(){
        def navmenu = NavMenu.list()
        [navmenu:navmenu]
    }

    def save(){

        def navInstance = new NavMenu(params)
        navInstance.setAdmin(springSecurityService.getCurrentUser())

        if(navInstance.validate()){
            navInstance.save(flush: true,failOnError: true)
            flash.message= (message(code: 'category.success'))
            redirect(action: 'createCategory')
        }
        else {
            def navmenu = NavMenu.list()
           render (view: '/navMenu/createCategory', model: [navInstance: navInstance,navmenu:navmenu])
        }
    }
}
