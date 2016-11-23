import loginWithMail.Role
import loginWithMail.User
import loginWithMail.UserRole

class BootStrap {

    def init = { servletContext ->
        if(!Role.findByAuthority("ROLE_ADMIN")) {
            new Role(authority: "ROLE_ADMIN").save(flush: true)
            new Role(authority: "ROLE_USER").save(flush: true)
        }
        if(User.list().size() == 0) {
            User user = new User(firstname: 'ravi', username: "test" , password: "123456",email:"ravi.kumar@jellyfishtechnologies.com")
            user.save(flush: true)
            UserRole userRole = new UserRole(user: user , role: Role.findByAuthority("ROLE_ADMIN"))

            userRole.save(flush: true)

        }
    }
    def destroy = {
    }
}
