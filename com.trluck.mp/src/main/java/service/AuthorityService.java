package service;

import dao.AuthorityDao;
import entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorityService {
    @Autowired
    AuthorityDao authorityDao;

    public List<Authority> listAuthority(){
        return authorityDao.listAuthority();
    }

    public Authority selectAuthorityById(Long arid){
        return authorityDao.selectAuthorityById(arid);
    }

    public void updeteEnabledById(Long arid,boolean enabled){
        authorityDao.updateEnableById(arid,enabled);
    }

    public void updateRoleById(Long arid,String role){
        authorityDao.updateRoleById(arid,role);
    }
}
