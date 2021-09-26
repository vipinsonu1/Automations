package apiTestCases.disposition;
import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.XLUtility;
import apiTestCases.LoginforJwtToken;
import files.resources;
import files.reuseableMethod;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;


public class creatCategory extends PropertiesFileAccess {

    int categoryId;
    int dispositionId;
    public creatCategory() throws IOException {
        super();
    }
    @DataProvider(name="catahgory")
    public Object[][] dataUserdetails()  throws IOException {



        String xlFilePath = System.getProperty("user.dir") + "/data/Disposition.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "dispositions");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "dispositions", 1);
        System.out.println(columnCount);

        String catahgory[][] = new String [rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++){
            for(int currentColumn = 0; currentColumn < columnCount; currentColumn++){
                catahgory[currentRow-1][currentColumn] = XLUtility.getCellData(xlFilePath, "dispositions", currentRow, currentColumn);
            }
        }
        return (catahgory);
    }

    @Test(dataProvider="catahgory",priority = 0)
    public void creatCategoryTest(String name,String disname,String subdisName,String authorization) throws IOException {
        LoginforJwtToken str= new LoginforJwtToken();
        str.LoginJwtTokenTest("token","/data/Disposition.xlsx");
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        requestparams.put("name",name);
        httpRequest.headers("Content-Type","application/json");
        httpRequest.headers("Authorization",authorization);
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.POST, resources.category() + "/category");
        System.out.println(response);

        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertEquals(responseBody.contains("success"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);

        JsonPath jp= reuseableMethod.rowToJson(response);

           System.out.println(jp.getString("response.id"));

        categoryId=Integer.parseInt(jp.getString("response.id"));
       System.out.println(categoryId);

     }


    @Test(dataProvider="catahgory", enabled = false)
    public void deleteCategoryTest(String name,String disname,String subdisName,String authorization) throws IOException {
        LoginforJwtToken str= new LoginforJwtToken();
        str.LoginJwtTokenTest("token","/data/Disposition.xlsx");
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given()
                .pathParam("id", categoryId);
        httpRequest.headers("Content-Type","application/json");
        httpRequest.headers("Authorization",authorization);
        Response response =httpRequest.request(Method.DELETE, resources.category() + "/category/{id}");
        System.out.println(response);

        String responseBody =response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test(dataProvider="catahgory",priority = 1)
    public void createdispositionTest(String name,String disname,String subdisName,String authorization) throws IOException {
        LoginforJwtToken str= new LoginforJwtToken();
        str.LoginJwtTokenTest("token","/data/Disposition.xlsx");
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        requestparams.put("categoryId",categoryId);
        requestparams.put("name",disname);
        httpRequest.headers("Content-Type","application/json");
        httpRequest.headers("Authorization",authorization);
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.POST, resources.dispositions() + "/disposition");
        System.out.println(response);

        String responseBody =response.getBody().asString();
        System.out.println(responseBody);

        JsonPath jp= reuseableMethod.rowToJson(response);

        System.out.println(jp.getString("response.id"));

        dispositionId=Integer.parseInt(jp.getString("response.id"));
        System.out.println(dispositionId);

    }

    @Test(dataProvider="catahgory",priority = 2)
    public void createsubdispositionTest(String name,String disname,String subdisName,String authorization) throws IOException {
        LoginforJwtToken str= new LoginforJwtToken();
        str.LoginJwtTokenTest("token","/data/Disposition.xlsx");
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject requestparams=new JSONObject();
        requestparams.put("dispositionId",dispositionId);
        requestparams.put("name",subdisName);
        httpRequest.headers("Content-Type","application/json");
        httpRequest.headers("Authorization",authorization);
        httpRequest.body(requestparams.toString());
        Response response =httpRequest.request(Method.POST, resources.dispositions() + "/sub/disposition");
        System.out.println(response);
        String responseBody =response.getBody().asString();
        System.out.println(responseBody);

    }

    }

