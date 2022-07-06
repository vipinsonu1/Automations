package apiTestCases.nlp;

import apiServer.utils.PropertiesFileAccess;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class intentCluster  extends PropertiesFileAccess {

    public intentCluster() throws IOException {
        super();
    }


    @BeforeClass
       public static void setupbaseUrl(){
        RestAssured.baseURI =  prop.getProperty("KOMPOSE");

      }


    @Test
    public void intentClusterTest() throws IOException {
        RestAssured.baseURI =  prop.getProperty("KOMPOSE");
        RequestSpecification httpRequest=RestAssured.given();

        httpRequest.headers("Content-Type","application/json").log().all();
        httpRequest.queryParam("applicationId","13502b850a6b45f737d1d499825ad365c");
        System.out.println("=================================================================");
        Response response =httpRequest.request(Method.GET, resources.nlp()).then().log().all().extract().response();
        String responseBody =response.getBody().asString();
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File file = new File(System.getProperty("user.dir")+"/test-output/nlp-output/"+dateFormat.format(date) + ".json");
        File fileObj = new File(String.valueOf(file));
        if(fileObj.createNewFile()) {
            FileWriter myWriter = new FileWriter(fileObj);
            myWriter.write(responseBody);
            myWriter.close();
        }else {
            System.out.println("Failed");
        }

    }

    @Test(priority = 1)
    public void intentClusterTest01() throws IOException {
        RestAssured.baseURI = prop.getProperty("KOMPOSE");
        given().
                headers("Content-Type", "application/json").
                queryParam("applicationId","1f9a132f2ab01b1572658b27ca14cd8f2").
                when().
                get("/intent/cluster").
                then().log().all().
                assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/vipinpandey/IdeaProjects/testcom/data/schemaApi/intentCluster.json")));
    }

    @DataProvider(name="ListOfApplications")
    public Object[][] applicationList(){
        Object[][] objects=new Object[2][3];
        objects[0][0]="kommunicate-support";
        objects[0][1]="application/json";
        objects[0][2]="Basic S29tcG9zZTpOTFA=";

        objects[1][0]="14d4ba62306d657d0c5170928d94a7ce0";
        objects[1][1]="application/json";
        objects[0][2]="Basic S29tcG9zZTpOTFA=";
        return objects;
    }


    @Test(dataProvider = "ListOfApplications")
    public void intentClusteragentResponseTest02(String applicationId,String content, String auth){
        //RestAssured.baseURI = prop.getProperty("KOMPOSE");
        HashMap<String,String > headers=new HashMap<>();
        headers.put("Content-Type", content);
        headers.put("Authorization",auth);

        HashMap<String,String > params=new HashMap<>();
        params.put("applicationId", applicationId);
        params.put("agentResponse","true");

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addParams(params);
        builder.addHeaders(headers);
        RequestSpecification requestSpec = builder.build();
        given().
                spec(requestSpec).
                when().
                get("/intent/cluster").
                then().log().body();

    }
}
