import dao.adminDao;
import dao.personDao;
import entity.Admin;
import entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class DaoTest {
    @Autowired
    private personDao personDao;

    @Autowired
    private adminDao adminDao;

    @Test
    public void personDAOTest() {
        long id = 1;
        personDao.updateDepartmentById(BCrypt.hashpw("lujianhui",BCrypt.gensalt()),id);

    }

    @Test
    public void AdminDaoTest(){
            adminDao.insertAdmin("xxxx5","2234");
    }

}


