package loginWithMail

import grails.transaction.Transactional
import org.codehaus.groovy.ast.expr.PostfixExpression

class PostException extends RuntimeException{
    String message
    Post post
}


@Transactional
class PostService {
    def springSecurityService
    Post createPost(String username,String content)
    {
        User user=springSecurityService.getCurrentUser()
        username = user.getUsername()
        if (user){
            def post=new Post(content: content)
            user.addToPosts(post)
            if (post.validate() && user.save()){
                return post
            }
            else {
                throw new PostException(message: "Invalid or empty post",post:post)
            }
        }
        throw new PostException(message: "Invalid User name")
    }

}
