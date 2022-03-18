package postCall;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PostCall {
    @Test  // post call
    public void postCall(){
        Response res = given().contentType("Application/json")
                .when().body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").post("https://reqres.in/api/users");
        res.prettyPrint();
        res.then().statusCode(201)
                .body("name",is("morpheus"));
        int code = res.statusCode();
        System.out.println("Status code is :" +code);
    }

    @Test    // assertion gets fail if we use hasItems because its single user.
    public void postcall(){
        Response  response1 = given().contentType("Application/json")
                .when().body("{\n" +
                        "    \"name\": \"Poonam\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").post("https://reqres.in/api/users");
        response1.prettyPrint();
        response1.then()
                .statusCode(201)
                .body("name", is("Poonam"));
    }
    @Test
    public void getListResource(){
        Response response = given()
                .when().get("https://reqres.in/api/unknown");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void  putCall(){
        Response response = given().contentType("Application/json")
                .when().body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}").put("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
