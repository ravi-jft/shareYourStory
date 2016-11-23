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
	String contact
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

	static hasMany = [navMenu:NavMenu]

	User(String firstname,String lastname,String email,String contact,String address, username, String password) {
		this()
		this.firstname=firstname
		this.lastname=lastname
		this.email=email
		this.contact=contact
		this.address=address
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
		firstname blank: false
		lastname nullable: true
		email email: true,unique: true
		contact nullable: true
		address nullable: true
		username blank: false, unique: true
		password blank: false
		token nullable: true
		linkcreateDate nullable: true
		linkuseDate nullable: true
	}

	static mapping = {
		password column: '`password`'
	}
}
