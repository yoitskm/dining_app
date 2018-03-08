package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 07/03/18.
 */

public class ObjItem {



    String id,title , unit , category , price , ItemImage;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUnit() {
        return unit;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getItemImage() {
        return ItemImage;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setItemImage(String itemImage) {
        ItemImage = itemImage;
    }

    public ObjItem(String id, String title, String unit, String category, String price, String itemImage) {

        this.id = id;
        this.title = title;
        this.unit = unit;
        this.category = category;
        this.price = price;
        ItemImage = itemImage;
    }
}
