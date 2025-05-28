package com.firstwebapp.todo.login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name") // we have to define sessAtrr in all class where we want to use it eg use in todocontroller
public class Logincontroller {
   
    // constructor injection for wiring things/classes
    // in order to inject authentication service spring uses @service annotation for service beans
     private AuthenticationService authenticationService;
     public Logincontroller(AuthenticationService authenticationService){
        super();
        this.authenticationService = authenticationService;
     }

     
    @RequestMapping(value="login",method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        // authentication 
        if(authenticationService.authenticate(name, password)){
            model.put("name",name);
            return "sayHello";
        }
        model.put("error","Invalid Credentials, Please try again!");
        return "login";
    } 
}
