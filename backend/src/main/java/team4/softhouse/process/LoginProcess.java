package team4.softhouse.process;

import team4.softhouse.db.entity.Login;


public interface LoginProcess {

    Login verify(Login login);
}
