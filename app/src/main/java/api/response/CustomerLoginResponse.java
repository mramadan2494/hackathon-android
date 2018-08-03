package api.response;



/**
 * Created by Shiko on 09/03/2017.
 */

public class CustomerLoginResponse {


    private String id;




    public CustomerLoginResponse() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerLoginResponse{" +
                "id='" + id + '\'' +
                '}';
    }
}
