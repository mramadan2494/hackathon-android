package api.response;



/**
 * Created by Shiko on 09/03/2017.
 */

public class CustomerLoginResponse {

    public static final String USERLOGIN_TOKEN="token";
    public static final String USERLOGIN_LOGINFROM = "loginFrom";

    private String token;




    public CustomerLoginResponse() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



}
