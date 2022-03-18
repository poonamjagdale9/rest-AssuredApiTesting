package getCall;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;

public class GetCall {
    @Test
    public void getCall(){
        Response response = given()
                .when().get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
        response.then().statusCode(200)
                .body("data.email",hasItems("michael.lawson@reqres.in"))
                .body("data.first_name", hasItems("Michael"));
        int code =response.statusCode();
        Assert.assertEquals(200 ,code);
        System.out.println("Satus code is :"+code);

    }
    @Test  // single user assert getting failed if we use hasItems
    public void getSingelCall1(){
        Response  resp = given()
                .when().get("https://reqres.in/api/users/2");
                resp.prettyPrint();
               resp .then()
                .statusCode(200)
               .body("data.email",is("janet.weaver@reqres.in"))
                       .body("data.last_name",is("Weaver"));
    }


       @Test
    public  void singleUserNotFoundGetcall(){
        Response response = given()
                .when().get("https://reqres.in/api/users/23");
        response.prettyPrint();
        response.then()
                .statusCode(404);   // not found

    }
    @Test // asssertion getting failed find out how to solve.
    public void dummyApi(){
        Response response = given()
                .when().get("https://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();
        response.then().statusCode(200)
                .body("data.id",is(2));

    }
}
