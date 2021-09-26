package files;


import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import  io.restassured.response.*;


public class reuseableMethod {

    public  static JsonPath rowToJson(Response r){


        String response=r.toString();
        JsonPath jp=new JsonPath(response);
        return jp;
    }


    public  static XmlPath rowToXml(Response r){


        String response=r.toString();
        XmlPath xp=new XmlPath(response);
        return xp;
    }
}
