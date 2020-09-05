package apiTestCases;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import files.reuseableMethod;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class botEnable {
    Properties prop=new Properties();

    @BeforeTest
    public  void getdata() throws IOException {
        FileInputStream fis=new FileInputStream("/Users/vipinpandey/IdeaProjects/testcom/src/main/java/com/km/config/evn.properties");
        prop.load(fis);
    }





    @Test
    public void appsetting() {

        RestAssured.baseURI = "https://api-test.kommunicate.io";

        Response response = null;


        try {

            response = given().
                    headers("Content-Type", "application/json")
                    .pathParam("appId", "38d131755975c00c843728ae01069b694")
                    .when()
                    .get("/settings/application/{appId}")

                    .then()
                    .contentType(ContentType.JSON)
                    .extract().response();


            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());


    }
     @Test
    public void reactivatebot() {

        RestAssured.baseURI = prop.getProperty("BOTHOST");

        Response resp = null;


        try {

            resp = given().
                    headers("Content-Type", "application/json")
                    .pathParam("appId", "38d131755975c00c843728ae01069b694")
                    .when()
                    .get(resources.getBotData()+ "{appId}")

                    .then()
                    .contentType(ContentType.JSON)
                    .extract().response();


            int statusCode = resp.getStatusCode();
            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + resp.getBody().asString());

                   JsonPath jp=reuseableMethod.rowToJson(resp);
                   int count=jp.get("size()");
                   for (int i=0; i< count; i++)
                   {
                       System.out.println(jp.getString("["+i+"].type"));
                   }
                   String  type=jp.getString("type[9]");
                  // Assert.assertEquals(type, "KOMMUNICATE_SUPPORT");

    }


        @Test
       public void main(){

          //  filterdisablebot();
            reactivatebot();

    }

}
