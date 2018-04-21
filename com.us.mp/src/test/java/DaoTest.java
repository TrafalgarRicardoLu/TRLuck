import dao.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.enums.MONTH;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class DaoTest {
    @Autowired
    private PersonDao personDao;


    @Test
    public void personDAOTest() {
        System.out.println(MONTH.valueOf("Jan"));
    }


}


