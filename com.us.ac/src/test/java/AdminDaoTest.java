import dao.AdminDao;
import entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;


    @Test
    public void AdminDaoTest() {

        adminDao.updateAnameById((long) 1,"trafalgar");
        System.out.println(adminDao.selectAdminById((long) 1).getAname());

    }

}


