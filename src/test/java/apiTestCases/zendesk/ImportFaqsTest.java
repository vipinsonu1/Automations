package apiTestCases.zendesk;

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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ImportFaqsTest extends PropertiesFileAccess {

    public ImportFaqsTest() throws IOException {
        super();
    }

    @Test
    public void importFaqsTest() throws IOException {
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        requestparams.put("url","https://kommunicate2346.zendesk.com");
        requestparams.put("email","vipin+kom10@kommunicate.io");
        requestparams.put("password","123456");

        httpRequest.headers("Content-Type","application/json");
        //httpRequest.header ("x-authorization","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3VzlQVHVaUnZVaHlrSzNSMUd1N2RIdnZlOEl3UEtGdSIsInVzZXJLZXkiOiI3YThhOTkyYi1lNjkzLTRlZmUtOTFlNy0wNzJiODBiOGEyN2QiLCJhcHBsaWNhdGlvbklkIjoiMTlhN2Y0OTA3ZGZmMTk4N2Y4MjkyMjc1ODk1ODI4NWJiIiwiZGV2aWNlS2V5IjoiYzk2ODgwMTItY2ZhMC00ZDU1LWI1OGYtMGE2MGVkZTZjNDI3IiwiY3JlYXRlZEF0VGltZSI6MTYyMzczNDQ3OTc3NCwidmFsaWRVcHRvIjo0MzIwMH0.pidcAv8G1tM_xvWRHmbdLfDbbeTbXP2Aa7L5khURjp4");
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.POST, resources.zendesk() + "/import-faqs");
        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
        //Assert.assertEquals(responseBody.contains("application settings updated successfully"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test(priority = 1)
    public void importFaqsTest01() throws IOException {
        RestAssured.baseURI = prop.getProperty("HOST");
        Map<String, Object> map = new HashMap<>();
        map.put("url", "https://kommunicate2346.zendesk.com");
        map.put("email", "vipin+kom10@kommunicate.io");
        map.put("password", "123456");
                given().
                headers("Content-Type", "application/json").body(map).
                when().
                post("/zendesk/import-faqs").
                then().log().all().
                assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/vipinpandey/IdeaProjects/testcom/data/importschema.json")));
    }

}
