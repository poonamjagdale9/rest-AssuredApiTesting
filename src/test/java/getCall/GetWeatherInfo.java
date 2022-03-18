package getCall;

import static io.restassured.RestAssured.*;   // we need to do it manually

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

public class GetWeatherInfo {
    @Test
    public void testRestAssured(){
        Response response = //get("http://dummy.restapiexample.com/api/v1/employees");
       // int code =response.statusCode();
      //  System.out.println("Statuscode is :" + code);
       // Assert.assertEquals(200,code);
      // String data = response.asString();
      // System.out.println(data);
       response= given().contentType(ContentType.JSON).log().body().get("http://dummy.restapiexample.com/api/v1/employees");
        given().
                when().
                then()
                .statusCode(200);



       response.prettyPrint();


    }
}
