package apiTestCases.dialog360;

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

public class featchingApplicationId  extends PropertiesFileAccess {
    public featchingApplicationId() throws IOException {
    }

    @Test
    public void featchingApplicationIdTest() throws IOException {
        RestAssured.baseURI =  prop.getProperty("DIALOG");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        httpRequest.headers("Content-Type","application/json");
        httpRequest.header ("D360-API-KEY","ZMlPJLw9E10vPHTtkZ6WMABPAK");
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.GET,  "v1/configs/webhook");
        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
        //Assert.assertEquals(responseBody.contains("application settings updated successfully"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
