package apiTestCases;

import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.RestClient;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.km.util.JwtToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.Assert;
import files.resources;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;


public class LoginforJwtToken extends PropertiesFileAccess {

    PropertiesFileAccess propertiesFileAccess;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;
    String serviceUrl;
    String url;
    resources resources;

    public LoginforJwtToken() throws IOException {
        super();
    }


//    public void setUp() throws  IOException {
//        propertiesFileAccess = new PropertiesFileAccess();
//        serviceUrl = prop.getProperty("HOST");
//        url = serviceUrl + resources.getLogin();
//
//    }

    public JSONObject LoginJwtTokenTest(String loginJwtToken, String pathExcelfile) throws IOException {
        propertiesFileAccess = new PropertiesFileAccess();
        serviceUrl = prop.getProperty("HOST");
        url = serviceUrl + resources.getLogin();
        String responseString = null;
        restClient = new RestClient();
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        //jacksonapi
        ObjectMapper mapper = new ObjectMapper();
        JwtToken users = new JwtToken("vipin+testkm01012018@kommunicate.io", "abcdef", "3c951e76437b755ce5ee8ad8a06703505", "");
        //JwtToken users = new JwtToken(userName,password,applicationId,applicationName);

        mapper.writeValue(new File("/Users/vipinpandey/IdeaProjects/testcom/data/Users.json"), users);
        String usersJsonString = mapper.writeValueAsString(users);

        System.out.println(usersJsonString);

        closeableHttpResponse = restClient.post(url, usersJsonString, headerMap); //call the API

        //validate response from API:
        //1. status code:
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, propertiesFileAccess.RESPONSE_STATUS_CODE_200);

        //2. JsonString:
        responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        JSONObject result = responseJson.getJSONObject("result");

        // System.out.println("The response from API is:" + responseJson);

        //json to java object:
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
/*       JwtToken usersResObj = mapper.readValue(responseString, JwtToken.class); //actual users object
       Assert.assertTrue(users.getUserName().equals(usersResObj.getUserName()));

         // read data from jsonobeject
        JSONObject result = responseJson.getJSONObject("result");
        String authToken = result.getJSONObject("applozicUser").getString("authToken");
        System.out.println("authtoken" + " :  " + authToken);

 */
        for (String objectName : result.keySet()) {
            if (loginJwtToken.equals(objectName)) {
                String token = responseJson.getJSONObject("result").getString("token");
                System.out.println("token " + "  :  " + token);

                FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + pathExcelfile));
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheetAt(0);
                //Create First Row
                XSSFRow row1 = sheet.getRow(1);
                XSSFCell cell1 = row1.getCell(3);
                cell1.setCellValue(token);
                fis.close();
                FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") + pathExcelfile));
                workbook.write(fos);
                fos.close();
                System.out.println("Done");
            }
        }
        return responseJson;
    }

    public void writeTokenToExcel() throws IOException {

        JSONObject str = LoginJwtTokenTest("token","/data/Disposition.xlsx");

        String authToken = str.getJSONObject("applozicUser").getString("authToken");
    }

    @Test
    public void test() throws IOException {
        LoginJwtTokenTest("token","/data/Disposition.xlsx");
    }
}
