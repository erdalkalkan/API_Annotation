package stepDefinitions;

import enums.CHANGEPASSWORD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.APIUtilities;

import static io.restassured.RestAssured.given;

public class US_1_StepDef {

    Response response;


    @When("User connects to {string} and changes the password")
    public void userConnectsToAndChangesThePassword(String endPoint) {

        CHANGEPASSWORD cPass = CHANGEPASSWORD.CHANGEPASSWORD1;

        response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", APIUtilities.getMocksessID())
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

    @Then("User verifies the status code is {int}")
    public void userVerifiesTheStatusCodeIs(int expectedStatusCode) {

        Assert.assertEquals(expectedStatusCode,response.getStatusCode());
    }
}
