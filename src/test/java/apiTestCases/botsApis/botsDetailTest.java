package apiTestCases.botsApis;

import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.XLUtility;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class botsDetailTest extends PropertiesFileAccess {

    public botsDetailTest() throws IOException {
        super();
    }


    @DataProvider(name = "botDetails")
    public Object[][] dataBotsdetails() throws IOException {

        String xlFilePath = System.getProperty("user.dir") + "/data/AllBots.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "BotAll");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "BotAll", 1);
        System.out.println(columnCount);

        String botDetails[][] = new String[rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                botDetails[currentRow - 1][currentColumn] = XLUtility.getCellData(xlFilePath, "BotAll", currentRow, currentColumn);
            }
        }
        return (botDetails);
    }


    @Test(dataProvider = "botDetails")
    public void botDetailTest_001(String appId, String xauthorization) throws IOException {


        RestAssured.baseURI = prop.getProperty("BOTHOST");


        RequestSpecification httpRequest = RestAssured.given();


        httpRequest.headers("Content-Type", "application/json");
        httpRequest.headers("Authorization", xauthorization);


        Response response = httpRequest.request(Method.GET, resources.getBotData() + appId);

        //capture response
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertEquals(responseBody.contains("c4b92df5ecd1e9c4bc41902f97e5bb03"), true);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
