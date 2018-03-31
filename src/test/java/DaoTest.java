import dao.adminDao;
import dao.personDao;
import entity.Admin;
import entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
        String id = "3";
        personDao.insertNewPerson("ricardo","male",23,"123");

    }

    @Test
    public void AdminDaoTest(){
        Admin admin=adminDao.selectAdminByName("ricardo");
        System.out.println(admin.getAid()+" "+admin.getPassword()+" "+admin.getAuthority());
    }

}


