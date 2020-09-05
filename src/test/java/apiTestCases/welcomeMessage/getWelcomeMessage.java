package apiTestCases.welcomeMessage;

import files.resources;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class getWelcomeMessage {
    Properties prop = new Properties();

    @BeforeTest
    public void getdata() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/vipinpandey/IdeaProjects/testcom/src/main/java/files/evn.properties");
        prop.load(fis);
    }


    @Test
    public void getWelcomemsg() {

        RestAssured.baseURI = prop.getProperty("HOST");

        Response response = null;


        try {
            Map<String, Object> headerMap = new HashMap<String, Object>();
            headerMap.put("Content-Type", "application/json");
            headerMap.put("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjo2NjkzMCwiYXBwbGljYXRpb25JZCI6IjFhNTgzYWZjZWY5M2E0ZTRhZTAzMzU4Yjk5MzQ0NzJiNyIsImVtYWlsIjoidmlwaW4rdGVzdGttMDEwMTIwMjBAYXBwbG96aWMuY29tIiwicGFzc3dvcmQiOiIkMmIkMTAkd2tpZ2JnMnVxMkptcFUxVE5mMnA3T2NaQzhEYjB4UllPcFpobWlWYUZrRS5VWnhRSEJBWm0iLCJ1c2VyTmFtZSI6InZpcGluK3Rlc3RrbTAxMDEyMDIwQGFwcGxvemljLmNvbSIsInR5cGUiOjMsImdlbmVyYXRlZEF0IjoxNTk0OTY2NzQ1NzMwLCJlbmNyeXB0ZWQiOmZhbHNlfSwiaWF0IjoxNTk0OTY2NzQ1LCJleHAiOjE1OTQ5ODU0NjV9.kir5kaTaPjsid9hlTNer1cf_4bOAorR1eziKsm8z454");


            RequestSpecification httpRequest = RestAssured.given();
            JSONObject requestParams = new JSONObject();
            //JsonObject requestParams = new JsonObject();


            requestParams.put("userName", "vipin+testkm01012020@applozic.com");
            requestParams.put("appId", "1a583afcef93a4e4ae03358b9934472b7");
            requestParams.put("eventIds", "[3]");
            httpRequest.headers(headerMap);
            // .post("api/rest/ws/applications/events/by/ids")

            // .then()
            // .contentType(ContentType.JSON)
            //  .extract().response();

            httpRequest.body(requestParams.toString());
            response = httpRequest.post(resources.getWelcomemessage() + "/events/by/ids");


            String responseBody = response.getBody().asString();
            System.out.println("Response :" + responseBody);
            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, "200");
            //String successCode = response.jsonPath().get("SuccessCode");
            // Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());


    }

}
