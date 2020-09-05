package apiTestCases.supperAdmin;

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

public class changeEmailTest extends PropertiesFileAccess {

    public changeEmailTest() throws IOException {
        super();
    }


    @DataProvider(name = "loginDetails")
    public Object[][] dataLoginDetails() throws IOException {

        String xlFilePath = System.getProperty("user.dir") + "/data/AllBots.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "login");
        System.out.println(rowCount);

        int columnCount = XLUtility.getCellCount(xlFilePath, "login", 1);
        System.out.println(columnCount);

        String loginDetails[][] = new String[rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                loginDetails[currentRow - 1][currentColumn] = XLUtility.getCellData(xlFilePath, "login", currentRow, currentColumn);
            }
        }
        return (loginDetails);
    }


    @Test(dataProvider = "loginDetails")
    public void TeambotDetailTest_001( String xauthorization,String clientGroupId) throws IOException {


        RestAssured.baseURI = prop.getProperty("HOST");


        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.headers("Content-Type", "application/json");
        httpRequest.headers("X-Authorization", xauthorization);
        httpRequest.queryParam("clientGroupId",clientGroupId);

        Response response = httpRequest.request(Method.GET, resources.getteam());

        //capture response
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertEquals(responseBody.contains("c4b92df5ecd1e9c4bc41902f97e5bb03"), true);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

}
