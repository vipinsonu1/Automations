package apiServer.utils;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import io.restassured.specification.RequestSpecification;
import  io.restassured.response.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class authenticationToken extends PropertiesFileAccess{

    String payload="{\"userName\":\"vipin+testkm01012018@kommunicate.io\",\"password\":\"abcdef\",\"applicationName\":\"\",\"applicationId\":\"3c951e76437b755ce5ee8ad8a06703505\"}";
    public authenticationToken() throws IOException {
        super();
    }

    public String authenticationTokenforKommunicate() throws IOException {
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest= RestAssured.given();
        httpRequest.header("Content-Type","application/json");
      Response responseFromGenerateToken = httpRequest.body(payload).post("/rest/ws/loginv2");
        String jsonString = responseFromGenerateToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("result.token");
        System.out.println("token "+ tokenGenerated);
        return tokenGenerated;
    }



    public String authenticationTokenforApplozic() throws IOException {
        RestAssured.baseURI =  prop.getProperty("HOST");
        RequestSpecification httpRequest=RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        Response responseFromGenerateToken = httpRequest.body(payload).post("/rest/ws/loginv2");
        String jsonString = responseFromGenerateToken.getBody().asString();
        String authtokenGenerated = JsonPath.from(jsonString).get("result.applozicUser.authToken");
        System.out.println("authtoken "+ authtokenGenerated);
        return authtokenGenerated;
    }

}
