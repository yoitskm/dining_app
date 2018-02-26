package mis.oblabs.com.takeorder.pojo;

/**
 * Created by ato on 25/02/18.
 */

public class ItemData {

    String title, subTitle , url,keyword;
    int count,price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemData(String title, String subTitle, String url, String keyword, int count, int price) {

        this.title = title;
        this.subTitle = subTitle;
        this.url = url;
        this.keyword = keyword;
        this.count = count;
        this.price = price;
    }
}
