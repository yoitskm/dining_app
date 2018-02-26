package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 25/02/18.
 */

public class OrderData {


    String itemName;

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

    public OrderData(String itemName, int price, int count, int total) {

        this.itemName = itemName;
        this.count = count;
        this.total = total;
        this.price = price;
    }
}
