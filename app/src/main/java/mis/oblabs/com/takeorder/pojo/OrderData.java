package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 25/02/18.
 */

public class OrderData {

    String id;

    String itemName;


    String comment;


    int count , total,price;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderData(String id, String itemName, int price, int total, int count) {
        this.id = id;
        this.itemName = itemName;
        this.count = count;
        this.total = total;
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
