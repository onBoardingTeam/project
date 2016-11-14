package team4.softhouse.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.security.auth.Subject;
import java.security.Principal;

public class Login implements Principal {

    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private String username;

    @JsonProperty
    @NotEmpty
    private String password;

    @JsonProperty
    @NotEmpty
    private String role;

    public Login(){}

    public Login(String name, String password){
        this.username=name;
        this.password=password;
    }

    public Login(Integer id, String name, String password){

        this.id=id;
        this.username=name;
        this.password=password;
    }

    public Integer getId() {
        return id;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject){
        return false;
    }
}





