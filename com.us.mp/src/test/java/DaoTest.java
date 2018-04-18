import dao.personDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class DaoTest {
    @Autowired
    private personDao personDao;

    @Autowired
    private adminDao adminDao;

    @Test
    public void personDAOTest() {
                personDao.updateBirthById("1990-1-1", (long) 13);
    }

    @Test
    public void AdminDaoTest() {
        adminDao.insertAdmin("xxxx5", "2234");
    }

}


