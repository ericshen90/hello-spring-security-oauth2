import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author EricShen
 * @date 2019-12-10
 */
// @SpringBootTest
@RunWith(SpringRunner.class)
public class OAuth2ServerApplicationTests {

  @Test
  public void testPasswordEncoder() {
    System.out.println("======================================================");
    System.out.println(new BCryptPasswordEncoder().encode("admin"));
  }

}
