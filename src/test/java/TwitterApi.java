import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

public class TwitterApi {
     String apikey = "vuKx1wejdMZzF29qKVkNkvQsr";
     String apiToken = "KhYV3NAxMmzr6wgjWoQulKOCPLSPOiaM0NiM8K0FrUtnBPCxaT";
     String accessToken ="1205794538998128640-f14NpgnWORC1SVklO82Xvg7IQFZDa7";
     String accessTokenSecret = "XQuxe1aASZI1FiBRNSF0wiGIt6Bprjdk3nx3agY9i5tt2";
   // @Test
    public void twittPost(){
       Response response= RestAssured.given()
                .auth()
                .oauth(apikey,apiToken,accessToken,accessTokenSecret).

                when().post("https://api.twitter.com/1.1/statuses/update.json?status= Hello world");
        response.prettyPrint();
       // response.then().body("id-str",hasItem("1321500354291400707"));
        System.out.println(response.getStatusCode());
    }

   // @Test
    public void getTwitt(){
        Response response = given().auth().oauth(apikey,apiToken,accessToken,accessTokenSecret)
                .get("https://api.twitter.com/1.1/statuses/home_timeline.json");
        response.prettyPrint();
        //System.out.println(response.getBody().jsonPath().prettify()); other way to print response from twitter it will print all the posts of twitter.

        //response.then().assertThat().body("text",is("Hello"));

        JsonPath json = response.jsonPath();

        System.out.println(json.get("id_str"));

    }
@Test
    public void deleteTwitt(){
        Response response =given().auth().oauth(apikey,apiToken,accessToken,accessTokenSecret)
                .post("https://api.twitter.com/1.1/statuses/destroy/:1321512217007792129.json");
    }
}
