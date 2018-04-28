package controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AdminService;

/**
 * @author trafalgar
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/authority",method = RequestMethod.GET)
    public String showAuthority(){
        return "redirect:showAuthority.html";
    }

    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.GET)
    public String deleteAdminById(@Param("aid")Long aid){
        adminService.deleteAdminById(aid);
        return "redirect:showAuthority.html";
    }


}
