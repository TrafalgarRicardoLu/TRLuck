import dao.AdminDao;
import dao.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.enums.MONTH;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class DaoTest {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private AdminDao adminDao;

    @Test
    public void personDAOTest() {
        personDao.insertNewPerson("ad","male","1998-01-01","Tech");
    }

    @Test
    public void AdminDaoTest() {
        adminDao.insertAdmin("ricardo", BCrypt.hashpw("lujianhui",BCrypt.gensalt()));
    }


}


