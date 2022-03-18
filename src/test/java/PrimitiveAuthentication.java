import io.restassured.RestAssured;
import org.junit.Test;

// incomplete because site unresponsive

public class PrimitiveAuthentication {
    @Test
    public void test1(){
        int code = RestAssured.given().auth().preemptive().basic("","")
                .when().get("https://restapi.demoqa.com/authentication/CheckForAuthentication")
                .getStatusCode();
        System.out.println("status code is :"+ code);
    }
}
