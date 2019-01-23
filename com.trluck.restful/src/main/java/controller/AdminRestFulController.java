package controller;

import entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AdminService;

import java.util.List;

/**
 * @author trafalgar
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminRestFulController {

    private static Logger logger = LoggerFactory.getLogger(AdminRestFulController.class);

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Admin> selectAdmins(){
        return adminService.listAdmin();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Admin selectAdminById(@PathVariable("id")Long id){
        return adminService.selectAdminById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public @ResponseBody Admin updateAdmin(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
        return adminService.selectAdminById(admin.getId());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteAdminById(@PathVariable("id")Long id){
        adminService.deleteAdminById(id);
    }

     @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public void insertNewAdmin(@PathVariable("id")Long id,
                               @Param("name")String name,
                               @Param("password")String password,
                               @Param("authority")String authority){
        adminService.insertAdmin(name,password);
    }
}
