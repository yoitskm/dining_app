/**
 * Created by ajaythakur on 6/16/15.
 */
package mis.oblabs.com.takeorder.network;

import android.util.Log;

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
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiRestAdapter {

    protected final String TAG = getClass().getSimpleName();
    protected Retrofit mRestAdapter;
    protected RestApi mApi;

    static final String BASE_URL ="http://restorder.devrajinternational.com/";

    public ApiRestAdapter() {








        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();






        mRestAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)

               .addConverterFactory(GsonConverterFactory.create())
                .client(client)

                .build();
        mApi = mRestAdapter.create(RestApi.class); // create the interface

        Log.d(TAG, "BASE -- created");
    }










    //login
    public Call<ObjectLogin> login(ObjectLogin login ){
       return mApi.login(login);
    }




    //items
    public Call<List<ItemData>> items(){
        return mApi.getItems();
    }


    //tables
    public Call<List<TableData>> tables(){
        return mApi.getTables();
    }



    //order create
    public Call<ObjectOrder> generateOrder(ObjectCreateOrder order){
        return mApi.generateOrder(order);
    }




    //order create
    public Call<List<ObjLogin>> getLogin(String user , String pass){
        return mApi.getLogin(user , pass);
    }


    // get items


    //item get
    public Call<List<ObjItem>> getItems(String subGrpId){
        return mApi.getItem(subGrpId);
    }




    //get groups
    public Call<List<ObjGroup>> getGroups(){
        return mApi.getGroups();
    }


    //get sub groups
    public Call<List<ObjSubGroup>> getSubGroups(){
        return mApi.getSubGroups();
    }

    //get groups
    public Call<List<ObjHotel>> getHotels(){
        return mApi.getHotels();
    }

}


