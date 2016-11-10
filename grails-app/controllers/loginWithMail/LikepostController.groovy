package loginWithMail

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class LikepostController {
    def springSecurityService

  /*  def index() {
        def user = springSecurityService.getCurrentUser()
       // def here = $params.id
        *//*if(user.posts.likecount==0)*//*
        println("====================param.id in ============== "+params.id)
        def likepost = new Likepost(user: user,post:Post.findById(params.id),likeCount:1)
        likepost.save(flush:true,failOnError: true)
    }*/


}
