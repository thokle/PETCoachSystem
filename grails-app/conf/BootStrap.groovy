
import petcoachsystem.Role
    
import petcoachsystem.Athlete
    import petcoachsystem.User
import petcoachsystem.UserRole

class BootStrap {
    
    
    def init = { servletContext ->
       def userRole = getOrCreateRole("ROLE_USER")
        def adminRole = getOrCreateRole("ROLE_ADMIN")
       
       
         def adminUser = new User(
                    username: "admin",
                    password: "admin",
                    enabled: true).save()
            UserRole.create adminUser, adminRole
       
        
        
    }
    def destroy = {
    }
    
    private getOrCreateRole(name) {
        def role = Role.findByAuthority(name)
        if (!role) role = new Role(authority: name).save()
        if (!role)  println "Unable to save role ${name}"
        return role
    }
}
