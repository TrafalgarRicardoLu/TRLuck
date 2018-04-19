package controller;

import entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class adminRESTController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/{aid}",method = RequestMethod.GET)
    public Admin selectAdminById(@PathVariable("aid")Long id){
        return adminService.selectAdminById(id);
    }

    @RequestMapping(value = "/{aid}",method = RequestMethod.PUT)
    public void insertNewAdmin(@PathVariable("aid")Long id,
                               @Param("authority")String authority){
        adminService.updateAuthorityById(authority,id);
    }

    @RequestMapping(value = "/{aid}",method = RequestMethod.DELETE)
    public void deleteAdminById(@PathVariable("aid")Long id){
        adminService.deleteAdminById(id);
    }

     @RequestMapping(value = "/{aid}",method = RequestMethod.POST)
    public void insertNewAdmin(@PathVariable("aid")Long id,
                               @Param("aname")String aname,
                               @Param("password")String password,
                               @Param("authority")String authority){
        adminService.insertAdmin(aname,password);
    }
}
