package apiTestCases;

import files.resources;
import files.reuseableMethod;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class whitelabelPlan {


        Properties prop = new Properties();

        @BeforeTest
        public void getdata() throws IOException {
            FileInputStream fis = new FileInputStream("/Users/vipinpandey/IdeaProjects/testcom/src/main/java/files/evn.properties");
            prop.load(fis);
        }


    // getting all setting related to chat popup

    @Test
    public void whitelabel() {
        RestAssured.baseURI = prop.getProperty("HOST");
        Response resp = null;


        try {

            resp = given().
                    headers("Content-Type", "application/json")
                    .pathParam("appId", "3c951e76437b755ce5ee8ad8a06703505")
                    .when()
                    .get(resources.getAppsettingData()+ "{appId}")

                    .then()
                    .contentType(ContentType.JSON)
                    .extract().response();


            int statusCode = resp.getStatusCode();
            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + resp.getBody().asString());

        JsonPath jp = reuseableMethod.rowToJson(resp);
        int count = jp.get("data.size()");

        for (int i = 0; i < count; i++) {
            System.out.println(jp.getString("data["+i+"].appSettingId"));
        }

        String appSettingId= jp.getString("data[0].appSettingId");
        Assert.assertEquals(appSettingId, "658");


    }

    @Test
    public void updatewhitelabel() {
        RestAssured.baseURI = prop.getProperty("HOST");
        Response resp = null;




        String b = "  \"message\": \"With the growing trend of smart pho\"," +
                "\"delay\": 5000," +
                "\"templateKey\": 1";

        try {

            resp = given().
                     headers("Content-Type", "application/json")
                    .body(b)
                    .pathParam("appId", "2a1f1aafe13864d10034fc41985de9628")

                    .when().
                     headers("Content-Type", "application/json")
                   .patch(resources.getAppsettingData()+ "{appId}")

                    .then()
                    .contentType(ContentType.JSON)
                    .extract().response();


            int statusCode = resp.getStatusCode();
            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
            }
        catch (Exception e)
        {
            e.printStackTrace();
        }

      //  System.out.println("Response :" + resp.getBody().asString());

        JsonPath jp = reuseableMethod.rowToJson(resp);
        String  msg = jp.get("message");
        System.out.println(msg);
    }

}
