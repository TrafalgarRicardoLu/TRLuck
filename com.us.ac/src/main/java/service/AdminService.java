package service;

import dao.AdminDao;
import entity.Admin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author trafalgar
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public void insertAdmin(String aname, String password) {
        password = BCrypt.hashpw(password, BCrypt.gensalt());
        adminDao.insertAdmin(aname, password);
    }

    public List<Admin> listAdmin(){
        return adminDao.listAdmin();
    }

    public Admin selectAdminById(Long id) {
        return adminDao.selectAdminById(id);
    }


    public void updateAdmin(Admin admin) {
        Admin origin = selectAdminById(admin.getAid());
        if (!BCrypt.checkpw(origin.getPassword(), admin.getPassword())) {
            String password = admin.getPassword();
            password = BCrypt.hashpw(password, BCrypt.gensalt());
            adminDao.updatePasswordById(admin.getAid(), password);
        }
        if(!origin.getAname().equals(admin.getAname())){
            adminDao.updateAnameById(admin.getAid(),admin.getAname());
        }
    }

    public void deleteAdminById(Long aid) {
        adminDao.deleteAdminById(aid);
    }
}
