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

public class conversationWaitingQueue {
    Properties prop = new Properties();

    @BeforeTest
    public void getdata() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/vipinpandey/IdeaProjects/testcom/src/main/java/com/km/config/evn.properties");
        prop.load(fis);
    }


    @Test
    public void conversationQueue() {

        RestAssured.baseURI = prop.getProperty("HOST");

        Response response = null;


        try {
            Map<String, Object> headerMap = new HashMap<String, Object>();
            headerMap.put("Content-Type", "application/json");
            headerMap.put("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjo2NjkzMCwiYXBwbGljYXRpb25JZCI6IjFhNTgzYWZjZWY5M2E0ZTRhZTAzMzU4Yjk5MzQ0NzJiNyIsImVtYWlsIjoidmlwaW4rdGVzdGttMDEwMTIwMjBAYXBwbG96aWMuY29tIiwicGFzc3dvcmQiOiIkMmIkMTAkd2tpZ2JnMnVxMkptcFUxVE5mMnA3T2NaQzhEYjB4UllPcFpobWlWYUZrRS5VWnhRSEJBWm0iLCJ1c2VyTmFtZSI6InZpcGluK3Rlc3RrbTAxMDEyMDIwQGFwcGxvemljLmNvbSIsInR5cGUiOjMsImdlbmVyYXRlZEF0IjoxNTk0OTY2NzQ1NzMwLCJlbmNyeXB0ZWQiOmZhbHNlfSwiaWF0IjoxNTk0OTY2NzQ1LCJleHAiOjE1OTQ5ODU0NjV9.kir5kaTaPjsid9hlTNer1cf_4bOAorR1eziKsm8z454");


            RequestSpecification httpRequest = RestAssured.given()
                    .pathParam("appId", "38d131755975c00c843728ae01069b694");
            JSONObject requestParams = new JSONObject();


            requestParams.put("companySetting.enableWaitingQueue", true);
            requestParams.put("companySetting.conversationHandlingLimit", 2);

            httpRequest.headers(headerMap);
            // .post("api/rest/ws/applications/events/by/ids")

            // .then()
            // .contentType(ContentType.JSON)
            //  .extract().response();

            httpRequest.body(requestParams.toString());
            response = httpRequest.patch(resources.companySettings() + "{appId}");


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
