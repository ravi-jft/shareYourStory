package loginWithMail

import grails.rest.Resource
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.annotation.Resources
@Resource(uri = "/users")
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService
	String firstname
	String lastname
	String email
	Integer contact
	String address
	String username
	String password
	String token

	Integer attempts = 0 //take default value as 0.
	Date linkcreateDate
	Date linkuseDate
	boolean enabled= false
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static hasMany = [navMenu:NavMenu,cart:Cart]
	//static hasOne = [cart:Cart]

	User(String firstname,String email,String username, String password) {
		this()
		this.firstname=firstname
		this.email=email
		this.username = username
		this.password = password
	}



	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		firstname blank: false, matches: /^\p{L}+(?: \p{L}+)*$/
		lastname nullable: true, matches: /^\p{L}+(?: \p{L}+)*$/
		email email: true,unique: true
		contact nullable: true
		address nullable: true, matches: /^[^a-zA-Z0-9]*$/
		username blank: false, unique: true,matches: /^\p{L}+(?: \p{L}+)*$/
		password blank: false
		token nullable: true
		linkcreateDate nullable: true
		linkuseDate nullable: true

		//cart nullable: true   //there may not be even a single cart of User
	}

	static mapping = {
		password column: '`password`'
	}
}
