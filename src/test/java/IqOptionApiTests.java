import com.jayway.restassured.response.Response;
import com.sudyarov.util.Options;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import static com.jayway.restassured.RestAssured.given;

public class IqOptionApiTests {

    private Properties props = Options.loadProperties();

    public IqOptionApiTests() throws IOException {
    }

    @Test
    public void checkSuccessAuthorization() {
        Response response = given()
                .queryParam("email", props.getProperty("validEmail"))
                .queryParam("password", props.getProperty("validPassword"))
                .post(props.getProperty("apiBaseUrl"));
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void checkFailedAuthorizationWithInvalidEmail() {
        Response response = given()
                .queryParam("email", props.getProperty("invalidEmail"))
                .queryParam("password", props.getProperty("validPassword"))
                .post(props.getProperty("apiBaseUrl"));
        response.then().assertThat().statusCode(403);
    }

    @Test
    public void checkFailedAuthorizationWithInvalidPassword() {
        Response response = given()
                .queryParam("email", props.getProperty("validEmail"))
                .queryParam("password", props.getProperty("invalidPassword"))
                .post(props.getProperty("apiBaseUrl"));
        response.then().assertThat().statusCode(403);
    }

    @Test
    public void checkFailedAuthorizationWithInvalidEmailAndPassword() {
        Response response = given()
                .queryParam("email", props.getProperty("invalidEmail"))
                .queryParam("password", props.getProperty("invalidPassword"))
                .post(props.getProperty("apiBaseUrl"));
        response.then().assertThat().statusCode(403);
    }
}