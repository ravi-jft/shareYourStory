package loginWithMail

import grails.plugin.springsecurity.annotation.Secured

import java.beans.Statement

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

//@Transactional(readOnly = true)

@Secured(['ROLE_ADMIN'])
class ProductController {

 //   static scaffold = true

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static defaultAction = "insertProduct"
    def index(){
        /*def navmenu = NavMenu.executeQuery("select id from NavMenu where id NOT IN(select parent.id from NavMenu where parent.id IS NOT NULL ) ")
        [navmenu:navmenu]*/
    }


    def insertProduct(){

       /* def id = NavMenu.executeQuery("select id from NavMenu where id NOT IN(select parent.id from NavMenu where parent.id IS NOT NULL ) ")*/
       // def navmenu = NavMenu.findAllById(id)

        def ids = NavMenu.executeQuery("select id from NavMenu where id NOT IN(select parent.id from NavMenu where parent.id IS NOT NULL ) ")
       // println("===============dynamic finder ==========="+navmenu)
        /*[navmenu:navmenu]*/
       /* def navmenu = NavMenu.findByIdNotEqualAndParentIsNotNull()
        println("===============dynamic finder ==========="+navmenu)*/
        println "---------ids-----------"+ids
          List<NavMenu> menus=  NavMenu.createCriteria().list {
              'in'('id',ids)
          }
        println("===============navmenu ==========="+menus*.category)
        [menus:menus]
    }

  /*  def save(){
        withForm {
            def product = new Product(params)
            if (product.validate()) {
                product.save(flush: true)
            }
            else {
                *//*flash.error = "some errors"
                render (view:'/product/index')*//*
                render "some errors"
            }
        }.invalidToken{

        }
    }*/

    def save(){
        def product = new Product(params)
        if (product.validate()){
            product.save(flush: true)
            flash.message = message(code: 'product.success')
            //render (view: '/product/insertProduct') //render doesn't populate data
            redirect(action: 'insertProduct')
        }
        else {
            render "some errors"
        }
    }

    def show(){  //view the product
        def product = Product.list()
        [product:product]
    }

    def edit(){   //update the product
        def product = Product.list()
        [product:product]
    }

  /*  def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model: [productInstanceCount: Product.count()]
    }

    def show(Product productInstance) {
        respond productInstance
    }

    def create() {
        respond new Product(params)
    }

    @Transactional
    def save(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view: 'create'
            return
        }

        productInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: CREATED] }
        }
    }

    def edit(Product productInstance) {
        respond productInstance
    }

    @Transactional
    def update(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view: 'edit'
            return
        }

        productInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        productInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }*/
}
