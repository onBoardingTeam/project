package team4.softhouse.auth;


import io.dropwizard.auth.Authorizer;
import team4.softhouse.db.entity.Login;
import team4.softhouse.process.LoginProcess;

import javax.ws.rs.ForbiddenException;
public class LoginAuthorizer implements Authorizer<Login> {

    private LoginProcess loginProcess;
    public LoginAuthorizer(LoginProcess loginProcess){
        this.loginProcess = loginProcess;
    }
    @Override
    public boolean authorize(Login login, String role) throws ForbiddenException {

        Login test = this.loginProcess.verify(login);
        return test.getRole().equals("adm") && role.equals("ADMIN");
    }
}
