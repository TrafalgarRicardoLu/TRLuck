import dao.personDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/applicationContext.xml", "classpath:/dispatcher-servlet.xml" })
public class DaoTest {
    @Autowired
    private personDao personDao;

    @Test
    public void InsertTest(){
        long id =0;
        personDao.insertNewPerson(id,"trafalgar","male",20);
    }

}
