package apiTestCases.awayMessage;

import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.XLUtility;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class awayMessage  extends PropertiesFileAccess {
    public awayMessage() throws IOException {
        super();
    }


    @DataProvider(name = "createContext")
    public Object[][] dataTeamAndBot() throws IOException {

        String xlFilePath = System.getProperty("user.dir") + "/data/context.xlsx";
        int rowCount = XLUtility.getRowCount(xlFilePath, "context");
        System.out.println(rowCount);
        int columnCount = XLUtility.getCellCount(xlFilePath, "context", 1);
        System.out.println(columnCount);

        String createContext[][] = new String[rowCount][columnCount];
        for (int currentRow = 1; currentRow <= rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                createContext[currentRow - 1][currentColumn] = XLUtility.getCellData(xlFilePath, "context", currentRow, currentColumn);
            }
        }
        return (createContext);
    }

    @Test(priority = 1, dataProvider = "createContext")
    public void getContxt(String appId, String authorization, String botKey) throws IOException {

        RestAssured.baseURI = prop.getProperty("HOST");

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.headers("Content-Type", "application/json");
        httpRequest.headers("Authorization", authorization);
        httpRequest.queryParam("botKey",botKey);
        //capture response
        Response response = httpRequest.request(Method.GET, resources.context());
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 1, dataProvider = "createContext")
    public void schemavalidationgetContxt(String appId, String authorization, String botKey) throws IOException {
        RestAssured.baseURI = prop.getProperty("HOST");
        // RequestSpecification httpRequest = RestAssured
        given().
                headers("Content-Type", "application/json").
                headers("Authorization", authorization).
                // queryParam("botKey",botKey).
                        when().
                get("/rest/ws/kompose/context?botKey=cfb0367a-33bb-4114-b8a9-346410315665").
                //request(Method.GET, resources.context()).
                        then().
                assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("context.json"));
    }
}
