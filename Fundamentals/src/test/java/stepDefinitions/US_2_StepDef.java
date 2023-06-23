package stepDefinitions;

import enums.CHANGEPASSWORD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.APIUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US_2_StepDef {


    Response response;

    @When("User connects to {string} and changes the password again")
    public void userConnectsToAndChangesThePasswordAgain(String endPoint) {


        CHANGEPASSWORD cPass = CHANGEPASSWORD.CHANGEPASSWORD2;

        Map<String, String> headerFiller = new HashMap<>();
        headerFiller.put("email","erdal@yopmail.com");
        headerFiller.put("password","1230123");
        headerFiller.put("state","candidate");

        String MOCKwithMap = APIUtilities.getMockSessionIdMap(headerFiller);

        response = given()
                .contentType(ContentType.JSON)
                .header("Cookie",MOCKwithMap)
                .body("{\n" +
                        "    \"oldPassword\": \""+cPass.getOldPassword()+"\",\n" +
                        "    \"newPassword\": {\n" +
                        "        \"first\": \""+cPass.getNewPassword()+"\",\n" +
                        "        \"second\": \""+cPass.getSecond()+"\"\n" +
                        "    }\n" +
                        "}")
                .when()
                .post(endPoint);

        response.prettyPrint();

    }

    @Then("User verifies the status code is {int} again")
    public void userVerifiesTheStatusCodeIsAgain(int expectedStatusCode) {

        Assert.assertEquals(expectedStatusCode,response.getStatusCode());

    }
}
