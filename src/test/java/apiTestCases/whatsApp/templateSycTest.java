package apiTestCases.whatsApp;

import apiServer.utils.PropertiesFileAccess;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class templateSycTest extends PropertiesFileAccess {
    public templateSycTest() throws IOException {
        super();
    }
    @Test
    public void templateSycTest() throws IOException {
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        requestparams.put("chatPlatformKey", "61c2d82c8fc4a630fb07f3b9");
        httpRequest.body(requestparams.toString());
        httpRequest.headers("Content-Type","application/json");
        //httpRequest.header ("x-authorization","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3VzlQVHVaUnZVaHlrSzNSMUd1N2RIdnZlOEl3UEtGdSIsInVzZXJLZXkiOiI3YThhOTkyYi1lNjkzLTRlZmUtOTFlNy0wNzJiODBiOGEyN2QiLCJhcHBsaWNhdGlvbklkIjoiMTlhN2Y0OTA3ZGZmMTk4N2Y4MjkyMjc1ODk1ODI4NWJiIiwiZGV2aWNlS2V5IjoiYzk2ODgwMTItY2ZhMC00ZDU1LWI1OGYtMGE2MGVkZTZjNDI3IiwiY3JlYXRlZEF0VGltZSI6MTYyMzczNDQ3OTc3NCwidmFsaWRVcHRvIjo0MzIwMH0.pidcAv8G1tM_xvWRHmbdLfDbbeTbXP2Aa7L5khURjp4");
        Response response =httpRequest.request(Method.POST, resources.whatsApp() + "/templates/sync");
        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
        //Assert.assertEquals(responseBody.contains("application settings updated successfully"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test(priority = 1)
    public void templateSycTest01() throws IOException {
        RestAssured.baseURI = prop.getProperty("HOST");
        given().
                headers("Content-Type", "application/json").
                when().
                post("chatplatform/whatsapp/dialog360/templates/sync").
                then().
                assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("feedback.json"));
    }
}
