package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.*;

public class APIUtilities {

    static Response response;

    public static String getMocksessID(){

        response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"erdal@yopmail.com\",\n" +
                        "    \"password\": \"123123\",\n" +
                        "    \"state\": \"candidate\"\n" +
                        "}")
                .when()
                .post("https://hyrai.com/api/login");

        String MOCKSESSID = "MOCKSESSID=" + response.cookie("MOCKSESSID");
        response.prettyPrint();
        System.out.println(MOCKSESSID);

        return MOCKSESSID;
    }

    public static String getMockSessionIdMap(Map<String, String> mapBody) {
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");


        String MOCKSESSID = "MOCKSESSID=" + response.cookie("MOCKSESSID");

        return MOCKSESSID;
    }

    public static void statusCodeAssertion(int statusCode){
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,actualStatusCode);
    }

    public static void statusAssertion(){
        boolean actualStatus = response.jsonPath().getBoolean("status");
        Assert.assertTrue(actualStatus);

    }



}
