package apiServer.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileAccess {


    public int RESPONSE_STATUS_CODE_200 = 200;
    public int RESPONSE_STATUS_CODE_500 = 500;
    public int RESPONSE_STATUS_CODE_400 = 400;
    public int RESPONSE_STATUS_CODE_401 = 401;
    public int RESPONSE_STATUS_CODE_201 = 201;

    public static Properties prop;

    public PropertiesFileAccess () throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/vipinpandey/IdeaProjects/testcom/src/main/java/com/km/config/evn.properties");
        prop.load(fis);
    }
}
