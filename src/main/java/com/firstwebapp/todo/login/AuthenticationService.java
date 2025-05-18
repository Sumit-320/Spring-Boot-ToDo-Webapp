package com.firstwebapp.todo.login;
import org.springframework.stereotype.Service;

// service component tells spring that this class holds business logic and instructs it to manage it as a bean to inject it wherever neede
// this class can be injected using auto-wiring
@Service 
public class AuthenticationService {

    public boolean authenticate(String username, String password){
            boolean isValidUserName = username.equalsIgnoreCase("sumit");
            boolean isValidPassword = password.equalsIgnoreCase("vish");
            return isValidUserName && isValidPassword;
    }
}
