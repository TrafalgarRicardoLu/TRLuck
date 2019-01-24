import dao.AdminDao;
import dao.PersonDao;
import entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class DaoTest {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private AdminDao adminDao;

    @Test
    public void personDAOTest() {
        personDao.insertNewPerson("ad", "male", "1998-01-01", "Tech");
    }

    @Test
    public void AdminDaoTest() {
        adminDao.insertAdmin("ricardo", BCrypt.hashpw("lujianhui", BCrypt.gensalt()));
    }

    @Test
    public void mybatisCache() {
        Person person=personDao.selectPersonById((long)1);
        System.out.println(person);
    }

}


