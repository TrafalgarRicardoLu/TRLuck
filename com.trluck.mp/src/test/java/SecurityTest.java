import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import utils.enums.MONTH;


public class SecurityTest {
    @Test
    public void BCrypt(){
        String password = "lujianhui1";
        String hashed = BCrypt.hashpw(password,BCrypt.gensalt());
        String hashed2 = BCrypt.hashpw(password,BCrypt.gensalt(12));

        System.out.println(hashed);
        System.out.println(hashed2);

        boolean matched = BCrypt.checkpw(password,hashed);
        System.out.println(matched);
        System.out.println(MONTH.valueOf("Jan"));
    }
}
