package apiTestCases.feedback;

import apiServer.utils.PropertiesFileAccess;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class feedback extends PropertiesFileAccess {

    public feedback() throws IOException {
    }

    @Test
    public void feedbackTest() throws IOException {
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        httpRequest.headers("Content-Type","application/json");
        httpRequest.header ("x-authorization","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3VzlQVHVaUnZVaHlrSzNSMUd1N2RIdnZlOEl3UEtGdSIsInVzZXJLZXkiOiI3YThhOTkyYi1lNjkzLTRlZmUtOTFlNy0wNzJiODBiOGEyN2QiLCJhcHBsaWNhdGlvbklkIjoiMTlhN2Y0OTA3ZGZmMTk4N2Y4MjkyMjc1ODk1ODI4NWJiIiwiZGV2aWNlS2V5IjoiYzk2ODgwMTItY2ZhMC00ZDU1LWI1OGYtMGE2MGVkZTZjNDI3IiwiY3JlYXRlZEF0VGltZSI6MTYyMzczNDQ3OTc3NCwidmFsaWRVcHRvIjo0MzIwMH0.pidcAv8G1tM_xvWRHmbdLfDbbeTbXP2Aa7L5khURjp4");
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.GET, resources.apiSecure() + "/feedback/433255");
        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
        //Assert.assertEquals(responseBody.contains("application settings updated successfully"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
