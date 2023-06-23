package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apiguardian.api.API;
import org.junit.Assert;
import utilities.APIUtilities;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.MOCKSESSID;

public class US02_StepDef {

    Response response;

    @When("User connect {string} and changes password again")
    public void userConnectAndChangesPasswordAgain(String endPoint) {

        response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", MOCKSESSID)
                .body("{\n" +
                        "    \"oldPassword\": \"1230123\",\n" +
                        "    \"newPassword\": {\n" +
                        "        \"first\": \"123123\",\n" +
                        "        \"second\": \"123123\"\n" +
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
