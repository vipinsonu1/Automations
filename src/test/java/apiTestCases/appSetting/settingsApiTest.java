package apiTestCases.appSetting;

import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.XLUtility;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class settingsApiTest extends PropertiesFileAccess {
    public settingsApiTest() throws IOException {
        super();
    }
    @DataProvider(name="appsettings")
    public Object[][] dataUserdetails()  throws IOException {

        String xlFilePath = System.getProperty("user.dir") + "/data/TestData1.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "setting");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "setting", 1);
        System.out.println(columnCount);

        String appsettings[][] = new String [rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++){
            for(int currentColumn = 0; currentColumn < columnCount; currentColumn++){
                appsettings[currentRow-1][currentColumn] = XLUtility.getCellData(xlFilePath, "setting", currentRow, currentColumn);
            }
        }
        return (appsettings);
    }

    @Test(dataProvider="appsettings")
    public void settingsTest(String voiceInput,String authorization) throws IOException {
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        requestparams.put("voiceInput",voiceInput);
        httpRequest.headers("Content-Type","application/json");
        httpRequest.headers("Authorization",authorization);
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.PATCH, resources.appsettings() + "/detail");
        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertEquals(responseBody.contains("application settings updated successfully"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

}
