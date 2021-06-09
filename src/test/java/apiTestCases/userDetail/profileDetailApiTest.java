package apiTestCases.userDetail;

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

public class profileDetailApiTest extends PropertiesFileAccess {

    public profileDetailApiTest() throws IOException {
        super();
    }

    @DataProvider (name="userdetails")
    public Object[][] dataUserdetails()  throws IOException {

        String xlFilePath = System.getProperty("user.dir") + "/data/TestData1.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "Sheet1");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "Sheet1", 1);
        System.out.println(columnCount);

        String userdetails[][] = new String [rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++){
            for(int currentColumn = 0; currentColumn < columnCount; currentColumn++){
                userdetails[currentRow-1][currentColumn] = XLUtility.getCellData(xlFilePath, "Sheet1", currentRow, currentColumn);
            }
        }
        return (userdetails);
    }




    @Test(dataProvider="userdetails")
    public void profileDetailTest(String username,String authorization) throws IOException {


        RestAssured.baseURI =  prop.getProperty("HOST");


        //RestAssured.baseURI="https://api-test.kommunicate.io/rest/ws/users";
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject requestparams=new JSONObject();
        requestparams.put("userName",username);



        httpRequest.headers("Content-Type","application/json");
        httpRequest.headers("Authorization",authorization);

        httpRequest.body(requestparams.toString());

        Response response =httpRequest.request(Method.POST, resources.profileusers() + "/detail");

        //capture response
       String responseBody =response.getBody().asString();
       System.out.println(responseBody);
        Assert.assertEquals(responseBody.contains("akshat+testkm31072020@kommunicate.io"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }


}
