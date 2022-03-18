package postCall;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TwitterApiPractice {
    String apiKey = "Ku6Ok7M40kxBxOl6aIqPDLJeZ";
    String apiSecretkey = "naBU9FQCQXkhMXtXgoMt4Gnftfy0jWpqRS0W7czzilmMm82qre";
    String accessToken = "1205794538998128640-WVLGX2TBMaU3dsiFI903go2OY5rUn4";
    String accessTokenSecret ="fAgflTYA6ervhcDp6QBtTtiYHhyEO6uYCbQf3hEYgGESE";
    @Test
    public void twittPost(){
        Response response= given()
                .auth()
                .oauth(apiKey,apiSecretkey,accessToken,accessTokenSecret).queryParam("status","Tweet from Api")
                .when()
                .post("https://api.twitter.com/1.1/statuses/update.json");
                response.prettyPrint();
                    System.out.println(response.getStatusCode());
    }
}
