package team4.softhouse.process;


import team4.softhouse.db.LoginDAO;
import team4.softhouse.db.entity.Login;

import javax.ws.rs.NotAuthorizedException;
import java.util.Optional;

public class LoginProcessDbImpl implements LoginProcess {
    private LoginDAO loginDAO;
    public LoginProcessDbImpl(LoginDAO loginDAO){this.loginDAO = loginDAO;}

    @Override
    public Login verify(Login login) throws NotAuthorizedException{
        return Optional
                .ofNullable(this.loginDAO.findUserByUsername(login))

                .orElseThrow(() -> new NotAuthorizedException("Invalid Credentials"));


    }

}
