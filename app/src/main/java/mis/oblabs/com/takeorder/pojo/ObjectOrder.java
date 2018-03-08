package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 07/03/18.
 */

public class ObjectOrder {

    String orderStatus;
    String orderId;

    public ObjectOrder(String orderStatus, String orderId) {
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
