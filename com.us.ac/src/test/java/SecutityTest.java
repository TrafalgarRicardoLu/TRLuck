import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class SecutityTest {
    @Test
    public void BCrypt(){
        String password = "lujianhui1   ";
        String hashed = BCrypt.hashpw(password,BCrypt.gensalt());
        String hashed2 = BCrypt.hashpw(password,BCrypt.gensalt(12));

        System.out.println(hashed.length());
        System.out.println(hashed);
        System.out.println(hashed2);

        boolean matched = BCrypt.checkpw(password,hashed);
        System.out.println(matched);


    }
}
