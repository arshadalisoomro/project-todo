package pk.edu.project.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ADMIN on 12/6/2018.
 */
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
}
