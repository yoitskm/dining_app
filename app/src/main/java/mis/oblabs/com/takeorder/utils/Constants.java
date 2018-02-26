package mis.oblabs.com.takeorder.utils;

import java.util.ArrayList;
import java.util.List;

import mis.oblabs.com.takeorder.pojo.ItemData;
import mis.oblabs.com.takeorder.pojo.OrderData;

/**
 * Created by ato on 25/02/18.
 */

public class Constants {


    public static List<OrderData> getOrders(){

        List<OrderData> orders = new ArrayList<>();
        orders.add(new OrderData("French Fries" , 40,1,40));
        orders.add(new OrderData("Mexican Burger" , 120,1,40));
        orders.add(new OrderData("Hakka Noodles" , 90,1,40));
        orders.add(new OrderData("Garlic Bread" , 80,1,40));
        orders.add(new OrderData("Paneer Tikka" , 220,1,40));
        orders.add(new OrderData("Dal Makhani" , 275,1,40));
        orders.add(new OrderData("Paneer Butter Masala" , 275,1,40));
        orders.add(new OrderData("Veg Raita" , 180,1,40));
        orders.add(new OrderData("Stuffed Naan" , 100,1,40));
        orders.add(new OrderData("Vanilla Icecream" , 120,1,40));
        return orders;
    }

    public static List<ItemData> getItems(){

        List<ItemData> orders = new ArrayList<>();
        orders.add(new ItemData("French Fries" , "Fresh potato dish","" , "Veg" , 100,80));
        orders.add(new ItemData("Mexican Burger" , "Fresh potato dish","" , "Veg" , 90,80));
        orders.add(new ItemData("Hakka Noodles" ,"Fresh potato dish","" , "Veg" , 10,80));
        orders.add(new ItemData("Garlic Bread" , "Fresh potato dish","" , "Veg" , 120,80));
        orders.add(new ItemData("Paneer Tikka" , "Fresh potato dish","" , "Veg" , 12,80));
        orders.add(new ItemData("Dal Makhani" ,"Fresh potato dish","" , "Veg" , 140,80));
        orders.add(new ItemData("Paneer Butter Masala" ,"Fresh potato dish","" , "Veg" , 100,80));
        orders.add(new ItemData("Veg Raita" , "Fresh potato dish","" , "Veg" , 100,80));
        orders.add(new ItemData("Stuffed Naan" , "Fresh potato dish","" , "Veg" , 10,80));
        orders.add(new ItemData("Vanilla Icecream" , "Fresh potato dish","" , "Veg" , 100,80));
        return orders;
    }
}
