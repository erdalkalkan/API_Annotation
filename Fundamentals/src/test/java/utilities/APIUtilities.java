package utilities;

import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.Hooks.*;

public class APIUtilities {

    public static String getMockSessionIdMap(Map<String, String> mapBody) {
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");

        return response.cookie("MOCKSESSID");
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
