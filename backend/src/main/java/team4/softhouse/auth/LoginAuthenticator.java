package team4.softhouse.auth;


import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import team4.softhouse.db.entity.Login;
import team4.softhouse.process.LoginProcess;

import java.util.Optional;


public class LoginAuthenticator implements Authenticator<BasicCredentials, Login> {

    private LoginProcess loginProcess;

    public LoginAuthenticator(LoginProcess loginProcess){
        this.loginProcess = loginProcess;
    }

    @Override
    public Optional<Login> authenticate(BasicCredentials credentials) throws AuthenticationException {
        Login login = new Login(credentials.getUsername(),credentials.getPassword());
        return Optional.ofNullable(this.loginProcess.verify(login));

    }
}
