package files;

public class resources {


    public  static String getAppsettingData(){
        String res="/settings/popup/";
        return res;
    }


    public  static String getBotData(){
        String res="/bot/";
        return res;
    }
    public  static String getAllBotData(){
        String res="/rest/ws/bot/list";
        return res;
    }
    public  static String singlegetBotData(){
        String res="/rest/ws/botdetails/";
        return res;
    }

    public  static String getteam(){
        String res="/rest/ws/team/get";
        return res;
    }
    public  static String dept(){
        String res="/rest/ws/";
        return res;
    }

    public  static String welcomemessage(){
        String res="/rest/ws/";
        return res;
    }
    public  static String getWelcomemessage(){
        String res="services/api/rest/ws/applications/";
        return res;
    }
    public  static String companySettings(){
        String res="settings/application/";
        return res;
    }
    public  static String profileusers(){
        String res="/rest/ws/users";
        return res;
    }
    public  static String appsettings(){
        String res="/rest/ws/settings/application";
        return res;
    }
    public  static String getLogin(){
        String res="/rest/ws/loginv2";
        return res;
    }
    public  static String category(){
        String res="/rest/ws/resolution";
        return res;
    }
    public  static String dispositions(){
        String res="/resolution";
        return res;
    }
}
