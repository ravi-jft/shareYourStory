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
        println("====================in createcategory=="+navmenu)
        [navmenu:navmenu]

    }

    def save(){

        def navmenu = new NavMenu(params)
        navmenu.setAdmin(springSecurityService.getCurrentUser())

        if(navmenu.validate()){
            navmenu.save(flush: true,failOnError: true)
            flash.message= (message(code: 'category.success'))
            redirect(action: 'createCategory')
        }
        else {
           render ("some errors")
           /* [err:err]*/
        }
    }
/*    static scaffold = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond NavMenu.list(params), model: [navMenuInstanceCount: NavMenu.count()]
    }

    def show(NavMenu navMenuInstance) {
        respond navMenuInstance
    }

    def create() {
        respond new NavMenu(params)
    }

    @Transactional
    def save(NavMenu navMenuInstance) {
        if (navMenuInstance == null) {
            notFound()
            return
        }

        if (navMenuInstance.hasErrors()) {
            respond navMenuInstance.errors, view: 'create'
            return
        }

        navMenuInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'navMenu.label', default: 'NavMenu'), navMenuInstance.id])
                redirect navMenuInstance
            }
            '*' { respond navMenuInstance, [status: CREATED] }
        }
    }

    def edit(NavMenu navMenuInstance) {
        respond navMenuInstance
    }

    @Transactional
    def update(NavMenu navMenuInstance) {
        if (navMenuInstance == null) {
            notFound()
            return
        }

        if (navMenuInstance.hasErrors()) {
            respond navMenuInstance.errors, view: 'edit'
            return
        }

        navMenuInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'NavMenu.label', default: 'NavMenu'), navMenuInstance.id])
                redirect navMenuInstance
            }
            '*' { respond navMenuInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(NavMenu navMenuInstance) {

        if (navMenuInstance == null) {
            notFound()
            return
        }

        navMenuInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'NavMenu.label', default: 'NavMenu'), navMenuInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'navMenu.label', default: 'NavMenu'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }*/
}
