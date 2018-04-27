package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author trafalgar
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/authority",method = RequestMethod.GET)
    public String showAuthority(){
        return "redirect:showAuthority.html";
    }
}
