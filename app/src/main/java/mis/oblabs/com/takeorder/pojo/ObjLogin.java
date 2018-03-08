package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 07/03/18.
 */

public class ObjLogin {



    String WaiterId , Waitername;

    public String getWaiterId() {
        return WaiterId;
    }

    public void setWaiterId(String waiterId) {
        WaiterId = waiterId;
    }

    public String getWaitername() {
        return Waitername;
    }

    public void setWaitername(String waitername) {
        Waitername = waitername;
    }

    public ObjLogin(String waiterId, String waitername) {

        WaiterId = waiterId;
        Waitername = waitername;
    }
}
