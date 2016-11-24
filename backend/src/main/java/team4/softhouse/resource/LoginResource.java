package team4.softhouse.resource;


import team4.softhouse.db.entity.Login;
import team4.softhouse.process.LoginProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static jersey.repackaged.com.google.common.base.Preconditions.checkNotNull;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {
    private LoginProcess loginProcess;

    public LoginResource(LoginProcess loginProcess){
        this.loginProcess = checkNotNull(loginProcess);
    }

    /*@GET
    @Path("/logout")
    public String logout(@Auth Login login){
        System.out.println(login);
        return login.getUsername();
    }
*/
    @POST
    public Login verifyLogin(Login login){
        return this.loginProcess.verify(login);
    }
}
