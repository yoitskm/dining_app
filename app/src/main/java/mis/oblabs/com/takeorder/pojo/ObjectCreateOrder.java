package mis.oblabs.com.takeorder.pojo;

import java.util.List;

/**
 * Created by ato on 07/03/18.
 */

public class ObjectCreateOrder {

    String userID;
    String tableID;
    String restoID;
    List<OrderData> items;

    public String getUserID() {
        return userID;
    }

    public String getRestoID() {
        return restoID;
    }

    public void setRestoID(String restoID) {
        this.restoID = restoID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public List<OrderData> getItems() {
        return items;
    }

    public void setItems(List<OrderData> items) {
        this.items = items;
    }

    public ObjectCreateOrder(String userID, String tableID, String restoID, List<OrderData> items) {
        this.userID = userID;
        this.tableID = tableID;
        this.restoID = restoID;
        this.items = items;
    }
}
