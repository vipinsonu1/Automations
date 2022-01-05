package apiTestCases.nlp;

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

public class intentCluster  extends PropertiesFileAccess {
    public intentCluster() throws IOException {
        super();
    }

    @Test
    public void intentClusterTest() throws IOException {
        RestAssured.baseURI =  prop.getProperty("KOMPOSE");
        RequestSpecification httpRequest=RestAssured.given();

        httpRequest.headers("Content-Type","application/json");
        httpRequest.queryParam("applicationId","13502b850a6b45f737d1d499825ad365c");
        //httpRequest.header ("x-authorization","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3VzlQVHVaUnZVaHlrSzNSMUd1N2RIdnZlOEl3UEtGdSIsInVzZXJLZXkiOiI3YThhOTkyYi1lNjkzLTRlZmUtOTFlNy0wNzJiODBiOGEyN2QiLCJhcHBsaWNhdGlvbklkIjoiMTlhN2Y0OTA3ZGZmMTk4N2Y4MjkyMjc1ODk1ODI4NWJiIiwiZGV2aWNlS2V5IjoiYzk2ODgwMTItY2ZhMC00ZDU1LWI1OGYtMGE2MGVkZTZjNDI3IiwiY3JlYXRlZEF0VGltZSI6MTYyMzczNDQ3OTc3NCwidmFsaWRVcHRvIjo0MzIwMH0.pidcAv8G1tM_xvWRHmbdLfDbbeTbXP2Aa7L5khURjp4");

        Response response =httpRequest.request(Method.POST, resources.nlp());
        httpRequest.log().all();
        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
        //Assert.assertEquals(responseBody.contains("application settings updated successfully"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test(priority = 1)
    public void intentClusterTest01() throws IOException {
        RestAssured.baseURI = prop.getProperty("KOMPOSE");
        given().
                headers("Content-Type", "application/json").
                queryParam("applicationId","1f9a132f2ab01b1572658b27ca14cd8f2").
                when().
                post("/intent/cluster").
                then().log().all().
                assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/vipinpandey/IdeaProjects/testcom/data/schemaApi/intentCluster.json")));
    }
}
