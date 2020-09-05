package com.km.util;

import com.km.base.TestBase;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 40;

    public void switchToFrame() {
        driver.switchTo().frame("");

    }


    public static String getValueByJPath(JSONObject responsejson, String jpath){
        Object obj = responsejson;
        for(String s : jpath.split("/"))
            if(!s.isEmpty())
                if(!(s.contains("[") || s.contains("]")))
                    obj = ((JSONObject) obj).get(s);
                else if(s.contains("[") || s.contains("]"))
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
        return obj.toString();
    }


}
