package loginWithMail

import grails.plugin.springsecurity.annotation.Secured
@Secured(['permitAll'])
class PostController {
    def springSecurityService

    //global Timeline
       def timeline(){
           def max=params.max?:10
           def offset = params.offset?:0
           def postCount= Post.count()
           List<Post> post = Post.createCriteria().list(max: max,offset:offset) {
           }
           [post: post , postCount:postCount]
       }

    def postService //inject Service
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    //addPost with Service
    def addPost(String username,String content){
        try {
            def newPost = postService.createPost(username,content)
            flash.message = "Added new Post: ${newPost.content}"
        }
        catch (PostException ex){
            flash.message=ex.message
        }
        redirect(action: 'timeline',username:username)
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize()
    }


    def postlike() {
        User user = springSecurityService.getCurrentUser()
        print("======================================param.id========"+params.id)
        Post post = Post.findById(params.id)
        print("=========================param.id in post========"+post)
        Integer count = Likepost.countByUserAndPost(user,post)
        if (count == 0){
            Likepost like = new Likepost(user:(User)springSecurityService.getCurrentUser(),post: post)
            post.addToLikes(like)
            post.save(flush: true,failOnError: true)

            redirect (controller: 'post', action: 'timeline')
        }
    }

    def postcomment(){
        User user = springSecurityService.getCurrentUser()
        Post post = Post.findById(params.id)
        Commentpost comment = new Commentpost(user:(User)springSecurityService.getCurrentUser(),post: post,commentname:params.commentname)
        if (comment.validate()) {
            post.addToComments(comment)
            post.save(flush: true, failOnError: true)
        }
        else {
            render("some errors")
        }

        redirect (controller: 'post', action: 'timeline')
    }

    def search(){}

    def result(){
        def query= params.resultset
        if (!query){
            return [:]
        }
        def searchResult = Post.search(query, params)
        return [searchResult:searchResult]

    }

}
