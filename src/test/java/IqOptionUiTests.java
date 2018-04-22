import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.sudyarov.pages.MainPage;
import com.sudyarov.util.Options;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

public class IqOptionUiTests {

    private MainPage page;
    private Properties props = Options.loadProperties();

    public IqOptionUiTests() throws IOException {
    }

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        page = Selenide.page(MainPage.class);
    }

    @Test
    public void checkValidAuthorizationTest() {
        Options.generateWebDriver(props.getProperty("baseUrl"));
        page.setEmail(props.getProperty("validEmail"))
                .setPassword(props.getProperty("validPassword"))
                .clickLoginButton()
                .checkSuccessAuthorization();
    }

    @Test
    public void checkAuthorizationWithInvalidEmailTest() {
        Options.generateWebDriver(props.getProperty("baseUrl"));
        page.setEmail(props.getProperty("invalidEmail"))
                .setPassword(props.getProperty("validPassword"))
                .clickLoginButton()
                .checkFailedAuthorization();
    }

    @Test
    public void checkAuthorizationWithInvalidPasswordTest() {
        Options.generateWebDriver(props.getProperty("baseUrl"));
        page.setEmail(props.getProperty("validEmail"))
                .setPassword(props.getProperty("invalidPassword"))
                .clickLoginButton()
                .checkFailedAuthorization();
    }

    @Test
    public void checkAuthorizationWithInvalidEmailAndPasswordTest() {
        Options.generateWebDriver(props.getProperty("baseUrl"));
        page.setEmail(props.getProperty("invalidEmail"))
                .setPassword(props.getProperty("invalidPassword"))
                .clickLoginButton()
                .checkFailedAuthorization();
    }

}
