package service;

import dao.AdminDao;
import dao.AuthorityDao;
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

    @Autowired
    private AuthorityDao authorityDao;

    public void insertAdmin(String aname, String password) {
        password = BCrypt.hashpw(password, BCrypt.gensalt());
        adminDao.insertAdmin(aname, password);
    }

    public List<Admin> listAdmin() {
        return adminDao.listAdmin();
    }

    public Admin selectAdminById(Long id) {
        return adminDao.selectAdminById(id);
    }


    public void updateAdmin(Admin admin) {
        Admin origin = selectAdminById(admin.getId());
        if (!BCrypt.checkpw(origin.getPassword(), admin.getPassword())) {
            String password = admin.getPassword();
            password = BCrypt.hashpw(password, BCrypt.gensalt());
            adminDao.updatePasswordById(admin.getId(), password);
        }
        if (!origin.getName().equals(admin.getName())) {
            adminDao.updateAnameById(admin.getId(), admin.getName());
        }
        System.out.println(admin.getAuthority().getRole());
        if (!origin.getAuthority().getRole().equals(admin.getAuthority().getRole())) {
            authorityDao.updateRoleByAname(admin.getName(),admin.getAuthority().getRole());
        }
    }

    public void deleteAdminById(Long aid) {
        adminDao.deleteAdminById(aid);
    }
}
