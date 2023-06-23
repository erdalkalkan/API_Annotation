package stepDefinitions;


import enums.USERINFO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utilities.Driver;
import utilities.ReusableMethods;

import static enums.USERINFO.*;
import static io.restassured.RestAssured.given;

public class Hooks {


    Response response;

    public static String MOCKSESSID;

    public static WebDriver driver;

    public static Actions actions;
    public static ReusableMethods browserUtilities = new ReusableMethods();

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {

        driver = Driver.getDriver();

        actions = new Actions(driver);
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();

    }


    @Before("@DB")
    public void setupDatabase() {
        //DatabaseUtilities.createConnection();

    }

    @After("@DB")
    public void closeDatabase() {
        // DatabaseUtilities.closeConnection();

    }



    @Before("@CANDIDATE_ERDAL1")
    public void CANDIDATE_ERDAL1(){
        getMOCKSESSID(CANDIDATE_ERDAL1);
    }

    @Before("@CANDIDATE_ERDAL2")
    public void CANDIDATE_ERDAL2(){
        getMOCKSESSID(CANDIDATE_ERDAL2);
    }


       public String getMOCKSESSID(USERINFO userinfo){

           response = given()
                   .contentType(ContentType.JSON)
                   .body("{\n" +
                           "    \"email\": \""+userinfo.getEmail()+"\",\n" +
                           "    \"password\": \""+userinfo.getPassword()+"\",\n" +
                           "    \"state\": \""+userinfo.getState()+"\"\n" +
                           "}")
                   .when()
                   .post("https://hyrai.com/api/login");

           MOCKSESSID = "MOCKSESSID=" + response.cookie("MOCKSESSID");

           return MOCKSESSID;

       }





}