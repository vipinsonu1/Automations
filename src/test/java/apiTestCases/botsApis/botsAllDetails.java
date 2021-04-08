package apiTestCases.botsApis;

import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.XLUtility;
import files.resources;
import files.reuseableMethod;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.util.ArrayList;

public class botsAllDetails extends PropertiesFileAccess {
    ArrayList<String> botName = new ArrayList<String>();
    public botsAllDetails() throws IOException {
        super();
    }


    @DataProvider(name = "botDetails")
    public Object[][] dataBotsdetails() throws IOException {
        String xlFilePath = System.getProperty("user.dir") + "/data/AllBots.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "BotsDetails");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "BotsDetails", 1);
        System.out.println(columnCount);

        String botDetails[][] = new String[rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                botDetails[currentRow - 1][currentColumn] = XLUtility.getCellData(xlFilePath, "BotsDetails", currentRow, currentColumn);
            }
        }
        return (botDetails);
    }


    @Test(dataProvider = "botDetails", priority = 1)
    public void botDetailTest_001(String appId, String authorization) throws IOException {

        RestAssured.baseURI = prop.getProperty("HOST");
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Content-Type", "application/json");
        httpRequest.headers("Authorization", authorization);


        Response resp = httpRequest.request(Method.GET, resources.getAllBotData());

        //capture response
        String responseBody = resp.getBody().asString();

        //  -------------------------------//
        JsonPath jp = reuseableMethod.rowToJson(resp);
        int count = jp.get("data.size()");

        for (int i = 0; i < count; i++) {
           // System.out.println(jp.getString("["+i+"].name"));
            botName.add(jp.getString("["+i+"].name"));
        }
     //---------------------------------------//
        System.out.println(botName);
        Assert.assertEquals(responseBody.contains("2b00e5b99038cc6aa2c4460e76adc91fe"), true);
        int statusCode = resp.getStatusCode();
        Assert.assertEquals(statusCode, 200);


    }
     @Test(dataProvider = "botDetails", priority = 2)
    public void singleBotDetail(String appId, String authorization) throws IOException{
    RestAssured.baseURI = prop.getProperty("HOST");


    RequestSpecification httpRequest = RestAssured.given();


    httpRequest.headers("Content-Type", "application/json");
    httpRequest.headers("Authorization", authorization);


    Response resp = httpRequest.request(Method.GET, resources.singlegetBotData()+botName.get(0));
   // JsonPath jp = reuseableMethod.rowToJson(resp);
    String responseBody = resp.getBody().asString();
    System.out.println(responseBody);
    }
}
