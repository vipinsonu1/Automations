package apiTestCases;

import apiServer.utils.PropertiesFileAccess;
import apiServer.utils.RestClient;
import apiServer.utils.XLUtility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.km.util.JwtToken;
import com.km.util.Xls_Reader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import files.resources;

import java.io.File;
import java.io.IOException;
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

    @BeforeMethod
    public void setUp() throws IOException{
        propertiesFileAccess =new PropertiesFileAccess();
        serviceUrl = prop.getProperty("HOST");
        url = serviceUrl + resources.getLogin() ;

    }




        public  String LoginJwtTokenTest(){
            Xls_Reader reader=new Xls_Reader(System.getProperty("user.dir") + "/data/AllBots.xlsx");
            String sheetName="Sheet2";
        String responseString = null;
        restClient =new RestClient();
        HashMap<String,String> headerMap=new HashMap<String, String>();
        headerMap.put("Content-Type","application/json");

        //jacksonapi
            try {

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

                System.out.println(loginDetails);
                 String userName=loginDetails[1][0];

                String password=loginDetails[1][1];
                String applicationId=loginDetails[1][2];
                String applicationName=loginDetails[1][3];

                ObjectMapper mapper = new ObjectMapper();
             //   JwtToken users = new JwtToken("Vipin+testkm26082020@applozic.com", "Vipin123", "9d8ce075daac78b80bdbdbd23829bf8f", "");
                JwtToken users = new JwtToken(userName,password,applicationId,applicationName);

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
                System.out.println("The response from API is:" + responseJson);

                //json to java object:
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
               // JwtToken usersResObj = mapper.readValue(responseString, JwtToken.class); //actual users object
               // Assert.assertTrue(users.getUserName().equals(usersResObj.getUserName()));

             //  read data from jsonobeject
                JSONObject result = responseJson.getJSONObject("result");
                String authToken =result.getJSONObject("applozicUser").getString("authToken");
                System.out.println("auth token "+ authToken);

                String token = responseJson.getJSONObject("result").getString("token");
                System.out.println("token "+ token);

               if (!reader.isSheetExist("Sheet2")) {
                   // String xlFilePath = System.getProperty("user.dir") + "/data/AllBots.xlsx";

                   //  XLUtility.setCellData(xlFilePath,"Sheet2",2,1,token);
                   reader.addSheet("Sheet2");
               }
              reader.setCellData(sheetName,"token",2,token);

            }

            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println(e);
            }

            return responseString;
        }


        @Test
        public void test(){
           LoginJwtTokenTest();

        }

}
