package apiTestCases.welcomeMessage;

import files.resources;
import files.reuseableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class createWelcomeMessage {
    Properties prop = new Properties();

    @BeforeTest
    public void getdata() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/vipinpandey/IdeaProjects/testcom/src/main/java/files/evn.properties");
        prop.load(fis);
    }


    String requestBody = "{\r\n    \"messages\": [\r\n        {\r\n            \"eventId\": 3,\r\n            \"message\": \"hi\",\r\n            \"status\": 1,\r\n            \"category\": 1,\r\n            \"sequence\": 2,\r\n            \"metadata\": {\r\n                \"category\": \"ARCHIVE\",\r\n                \"skipBot\": true,\r\n                \"NO_ALERT\": true,\r\n                \"BADGE_COUNT\": false\r\n            },\r\n            \"languageCode\": null\r\n        }\r\n    ]\r\n}";

    @Test
    public void creatwlecomemessage() {

        RestAssured.baseURI = prop.getProperty("HOST");

        Response resp = null;


        try {

            Map<String, Object> headerMap = new HashMap<String, Object>();
            headerMap.put("Content-Type", "application/json");
            headerMap.put("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjo2NjkzMCwiYXBwbGljYXRpb25JZCI6IjFhNTgzYWZjZWY5M2E0ZTRhZTAzMzU4Yjk5MzQ0NzJiNyIsImVtYWlsIjoidmlwaW4rdGVzdGttMDEwMTIwMjBAYXBwbG96aWMuY29tIiwicGFzc3dvcmQiOiIkMmIkMTAkd2tpZ2JnMnVxMkptcFUxVE5mMnA3T2NaQzhEYjB4UllPcFpobWlWYUZrRS5VWnhRSEJBWm0iLCJ1c2VyTmFtZSI6InZpcGluK3Rlc3RrbTAxMDEyMDIwQGFwcGxvemljLmNvbSIsInR5cGUiOjMsImdlbmVyYXRlZEF0IjoxNTk0ODcwMzYxMTYyLCJlbmNyeXB0ZWQiOmZhbHNlfSwiaWF0IjoxNTk0ODcwMzYxLCJleHAiOjE1OTc0NjIzNjF9.Gn8OarvzHVnl9zmuSenCY5L4KHmmMmKUcPeZntW0UgU");

            resp = given().
                    headers(headerMap)
                    // header("Content-Type","application/json")
                    // .header("x-authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aXBpbit0ZXN0a20wNDEyMjAxOUBhcHBsb3ppYy5jb20iLCJ1c2VyS2V5IjoiYzFiNWU5ODktY2I1Yi00NTE0LWIwNmMtMjhkMzFmMjFmOThjIiwiYXBwbGljYXRpb25JZCI6IjIwYzBlN2FkNDMyMzYzMDM3MDVlYmY2M2ZmNTEwOTg0MiIsImRldmljZUtleSI6IjA4ZjVmNThiLWQ0MmQtNDIxMS1iMDZjLTAyOWU4NjE3MGFlYSIsInJvbGVOYW1lIjoiQVBQTElDQVRJT05fV0VCX0FETUlOIiwicGFzc3dvcmQiOiIkMmEkMTAkalg0cEthWFFqeGVNWVBzWjQ2WGN2LjFTOXhTU2ZnanNRRmpOVnVwa0ROT21jUnZyaFNqcm0iLCJjcmVhdGVkQXRUaW1lIjoxNTc1ODgxODY2NDE5LCJ2YWxpZFVwdG8iOjQzMjAwfQ.Sfci2_PR2MVizRONnyHnXuoAjxUPcyOVzGmE6RdmnCVioJZej5Dpsjz4J2OkijaGx9jMQVpHO-90yozVRs7xqQ")
                    .body(requestBody)
                    //.param("teamId",340162)
                    .when()
                    .post(resources.welcomemessage() + "/applications/vipin+testkm01012020@applozic.com/1a583afcef93a4e4ae03358b9934472b7/message/create")

                    .then()
//                    .contentType(ContentType.JSON)
                    .extract().response();


            int statusCode = resp.getStatusCode();
            System.out.println(resp.getBody().asString());

            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + resp.getBody().asString());

        JsonPath jp = reuseableMethod.rowToJson(resp);
        int count = jp.get("size()");
        for (int i = 0; i < count; i++) {
            System.out.println(jp.getString("[" + i + "].type"));
        }
        // String  type=jp.getString("type[9]");
        // Assert.assertEquals(type, "KOMMUNICATE_SUPPORT");
    }
}

