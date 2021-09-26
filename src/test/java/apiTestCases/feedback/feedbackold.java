package apiTestCases.feedback;

import apiServer.utils.PropertiesFileAccess;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class feedbackold extends PropertiesFileAccess {


    public feedbackold() throws IOException {
        super();
    }

    @Test(priority = 0)
    public void feedbackoldTest() throws IOException {
        //String json= (System.getProperty("user.dir") + "/data/feedback.json");
        RestAssured.baseURI = prop.getProperty("HOST");
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestparams = new JSONObject();
        httpRequest.headers("Content-Type", "application/json");
        httpRequest.body(requestparams.toString());
        Response response= httpRequest.request(Method.GET, "feedback/433255");
        // System.out.println(response);
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        //Assert.assertEquals(responseBody.contains("application settings updated successfully"),true);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }


    @Test(priority = 1)
    public void feedbackoldTest01() throws IOException {
        RestAssured.baseURI = prop.getProperty("HOST");
        given().
                headers("Content-Type", "application/json").
        when().
                get("feedback/433255").
         then().
                assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("feedback.json"));
    }
}
