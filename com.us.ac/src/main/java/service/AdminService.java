package service;

import dao.adminDao;
import entity.Admin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    adminDao adminDao;

    public void insertAdmin(String aname,String password){
        password = BCrypt.hashpw(password,BCrypt.gensalt());
        adminDao.insertAdmin(aname,password);
    }

    public Admin selectAdminById(Long id){
        return adminDao.selectAdminById(id);
    }

    public void updatePasswordById(Long aid,String password){
        password = BCrypt.hashpw(password,BCrypt.gensalt());
        adminDao.updatePasswordById(aid,password);
    }

    public void updateAuthorityById(String aid, Long Authority){
        adminDao.updateAuthorityById(aid,Authority);
    }

    public void deleteAdminById(Long aid){
        adminDao.deleteAdminById(aid);
    }
}
