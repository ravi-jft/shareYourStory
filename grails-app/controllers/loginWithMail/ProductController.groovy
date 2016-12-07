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

    static defaultAction = "addProduct"

    def index() {
    }


    def addProduct() {

        /* def id = NavMenu.executeQuery("select id from NavMenu where id NOT IN(select parent.id from NavMenu where parent.id IS NOT NULL ) ")*/
        // def navmenu = NavMenu.findAllById(id)

        def ids = NavMenu.executeQuery("select id from NavMenu where id NOT IN(select parent.id from NavMenu where parent.id IS NOT NULL ) ")
        List<NavMenu> menus = NavMenu.createCriteria().list {
            'in'('id', ids)
        }
        [menus: menus]
    }

    def save() {
        def productInstance = new Product(name: params.name, details: params.details, price: params.price, unit: params.unit, category: params.category)

        if (productInstance.validate()) {
            productInstance.save(flush: true, failOnError: true)
            def proImage = request.getFile('productImage')
            def okContentTypes = ['image/png', 'image/jpeg', 'image/jpg', 'image/gif']
            //there must be only this type of files
            if (!proImage?.empty && proImage.size < 1024 * 200 && okContentTypes.contains(proImage.getContentType())) {
                def imagepath = servletContext.getRealPath("/") + "productImages/" + proImage.getOriginalFilename()
                proImage.transferTo(new File(imagepath))
                productInstance.productImage = (String) proImage.getOriginalFilename()
                productInstance.save(flush: true, failOnError: true)
                flash.message = message(code: 'product.success')
                redirect(action: 'addProduct')

            } else {
                flash.message = message(code: 'default.prdouct.image')
                redirect(action: 'addProduct')
            }
        } else {
            def menus = NavMenu.executeQuery("from NavMenu where id NOT IN(select parent.id from NavMenu where parent.id IS NOT NULL ) ")
            render(view: "addProduct", model: [productInstance: productInstance, menus: menus])
        }
    }

    //@Secured(['ROLE_ADMIN','ROLE_USER'])
    @Secured(['permitAll'])
    def show() {  //view the product
        def product = Product.list()
        [product: product]
    }

    def edit() {   //update the product
        def product = Product.list()
        [product: product]
    }

    @Secured(['permitAll'])
    def savecart() {

    }

    @Secured(['permitAll'])
    def showcart() {
    }

    @Secured(['permitAll'])
     def savelocal(){
         def name= params.productname
         def price=params.price
         def productImage=params.productimage
         def id = params.id
         [name:name,price: price,productImage:productImage,id:id]
     }

    }

