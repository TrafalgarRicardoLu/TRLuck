import dao.AuthorityDao;
import entity.Authority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class AuthorityDaoTest {

    @Autowired
    AuthorityDao authorityDao;

    @Test
    public void daoTest() {
        authorityDao.updateRoleById((long) 1,"ROLE_ADMIN");
        Authority authority = authorityDao.selectAuthorityById((long) 1);
        System.out.println(authority.toString());
    }
}
