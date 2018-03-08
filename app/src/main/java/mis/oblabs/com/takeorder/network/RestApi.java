package mis.oblabs.com.takeorder.network;


import java.util.List;

import mis.oblabs.com.takeorder.pojo.ItemData;
import mis.oblabs.com.takeorder.pojo.ObjGroup;
import mis.oblabs.com.takeorder.pojo.ObjHotel;
import mis.oblabs.com.takeorder.pojo.ObjItem;
import mis.oblabs.com.takeorder.pojo.ObjLogin;
import mis.oblabs.com.takeorder.pojo.ObjSubGroup;
import mis.oblabs.com.takeorder.pojo.ObjectCreateOrder;
import mis.oblabs.com.takeorder.pojo.ObjectLogin;
import mis.oblabs.com.takeorder.pojo.ObjectOrder;
import mis.oblabs.com.takeorder.pojo.TableData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by kmagrawal on 03/03/18.
 */

public interface RestApi {



//    //login
//    @FormUrlEncoded
//    @POST("login")
//    Call<String> login(@Field("username") String userId, @Field("passw") String password);


    //login
    @POST("login")
    Call<ObjectLogin> login(@Body ObjectLogin login);


//
//

    ///login new
    //get list of items
    @GET("FrmWaiterLogin.aspx")
    Call<List<ObjLogin>> getLogin(@Query("user")String user , @Query("Pass") String pass);

    //get list of items
    @GET("items")
    Call<List<ItemData>> getItems();


    // generate order
    @POST("order")
    Call<ObjectOrder> generateOrder(@Body ObjectCreateOrder order);

 /// new apis
    //table list
    @GET("items")
    Call<List<TableData>> getTables();


    //get list of items
    @GET("ItemDetailsReport.aspx")
    Call<List<ObjItem>> getItem(@Query("SubGroupID")String subGrpId);
    //get list of groups
    @GET("FrmGroupReport.aspx")
    Call<List<ObjGroup>> getGroups();



    //get list of sub groups
    @GET("FrmSubGroupReport.aspx")
    Call<List<ObjSubGroup>> getSubGroups();

    //get list of hotels
    @GET("FrmSubGroupReport.aspx")
    Call<List<ObjHotel>> getHotels();


}


