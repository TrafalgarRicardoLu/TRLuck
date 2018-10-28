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
@RequestMapping(value = "/ac")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:http://localhost/index.html";
    }

    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
    public String deleteAdminById(@Param("aid") Long aid) {
        adminService.deleteAdminById(aid);
        return "/";
    }

    @RequestMapping(value = "/showAdmin", method = RequestMethod.GET)
    public String showAdmins() {
        return "showAdmin.html";
    }
}
