package apiTestCases.apps;

import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.authenticationToken;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class searchApi  extends PropertiesFileAccess {
    authenticationToken authtoken= new authenticationToken();

    public searchApi() throws IOException {
        super();
    }

    @Test
    public void searchTest() throws IOException {
        //authenticationToken authtoken= new authenticationToken();
        RestAssured.baseURI =  prop.getProperty("APPSHOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        httpRequest.headers("Content-Type","application/json");
        httpRequest.header("x-authorization", authtoken.authenticationTokenforApplozic());
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.GET, resources.apiSecure()+ "/group/support/search?startTime=1623695400169&endTime=1623781799169");


        String responseBody =response.getBody().asString();

        System.out.println(responseBody);

        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }



}
