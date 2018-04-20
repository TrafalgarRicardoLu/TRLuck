package service;

import dao.adminDao;
import entity.Admin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    adminDao adminDao;

    public void insertAdmin(String aname, String password) {
        password = BCrypt.hashpw(password, BCrypt.gensalt());
        adminDao.insertAdmin(aname, password);
    }

    public List<Admin> selectAdmins(){
        return adminDao.selectAdmins();
    }

    public Admin selectAdminById(Long id) {
        return adminDao.selectAdminById(id);
    }


    public void updateAdminById(Long aid, Admin admin) {
        Admin origin = selectAdminById(aid);
        if (!BCrypt.checkpw(origin.getPassword(), admin.getPassword())) {
            String password = admin.getPassword();
            password = BCrypt.hashpw(password, BCrypt.gensalt());
            adminDao.updatePasswordById(aid, password);
        }
        if(!origin.getAuthority().equals(admin.getAuthority())){
            adminDao.updateAuthorityById(aid,admin.getAuthority());
        }
    }

    public void deleteAdminById(Long aid) {
        adminDao.deleteAdminById(aid);
    }
}
