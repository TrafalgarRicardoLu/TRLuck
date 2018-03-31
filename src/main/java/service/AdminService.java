package service;

import dao.adminDao;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminService {

    @Autowired
    adminDao adminDao;

    public void insertAdmin(String aname,String password){
        adminDao.insertAdmin(aname,password);
    }

    public Admin selectAdminByName(String aname){
        return adminDao.selectAdminByName(aname);
    }

    public void updatePasswordById(Long aid,String password){
        adminDao.updatePasswordById(aid,password);
    }

    public void updateAuthorityById(Long aid,Integer Authority){
        adminDao.updateAuthorityById(aid,Authority);
    }

    public void deleteAdminById(Long aid){
        adminDao.deleteAdminById(aid);
    }
}
