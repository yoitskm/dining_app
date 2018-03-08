package mis.oblabs.com.takeorder.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.adapter.OrderItemAdapter;
import mis.oblabs.com.takeorder.adapter.TableAdapter;
import mis.oblabs.com.takeorder.fragment.GroupFragment;
import mis.oblabs.com.takeorder.fragment.ItemFragment;
import mis.oblabs.com.takeorder.fragment.SubGroupFragment;
import mis.oblabs.com.takeorder.network.ApiRestAdapter;
import mis.oblabs.com.takeorder.pojo.ObjectCreateOrder;
import mis.oblabs.com.takeorder.pojo.ObjectOrder;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Constants;
import mis.oblabs.com.takeorder.utils.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Button bttnCheckout;
    FloatingActionButton bttnAdd;
    OrderItemAdapter orderItemAdapter;
    TextView tvBlank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = findViewById(R.id.recycle_orders);
        bttnCheckout = findViewById(R.id.bttnCheckout);
        bttnCheckout.setOnClickListener(bttnCheckoutClicked());
        bttnAdd = findViewById(R.id.bttnAdd);
        tvBlank = findViewById(R.id.tvBlank);

        bttnAdd.setOnClickListener(newItemAddClicked());


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        orderItemAdapter = new OrderItemAdapter(Constants.getOrders() , getSupportFragmentManager());
        recyclerView.setAdapter(orderItemAdapter);
    }

    private View.OnClickListener bttnCheckoutClicked() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(tvBlank.getVisibility()== View.VISIBLE){
                    Helper.showToast(OrderActivity.this, "Order is empty");
                    return;
                }

                Helper.showLoading(OrderActivity.this , "Creating Order...");


                new ApiRestAdapter().generateOrder(new ObjectCreateOrder("1","1",orderItemAdapter.getList())).enqueue(new Callback<ObjectOrder>() {
                    @Override
                    public void onResponse(Call<ObjectOrder> call, Response<ObjectOrder> response) {
                        Helper.hideLoading();
                        Helper.showLongToast(OrderActivity.this , "Order Successfully Added");
                        finish();

                    }

                    @Override
                    public void onFailure(Call<ObjectOrder> call, Throwable t) {
                        Helper.showToast(OrderActivity.this , "Failed");
                        Helper.hideLoading();
                    }
                });

            }
        };
    }

    private View.OnClickListener newItemAddClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                ItemFragment fragment = ItemFragment.createInstance(itemCallback());
//                fragment.show(getSupportFragmentManager() , "Title");

                SubGroupFragment fragment = SubGroupFragment.createInstance(itemCallback());
                fragment.show(getSupportFragmentManager() , "groups");


//                getSupportFragmentManager().beginTransaction().add(R.id.frame, ItemFragment.createInstance(itemCallback())).addToBackStack(null).commit();

            }
        };
    }

    private ItemFragment.ItemCallback itemCallback() {
        return new ItemFragment.ItemCallback() {
            @Override
            public void itemSelected(OrderData data) {

                orderItemAdapter.addItemInList(data);
                tvBlank.setVisibility(View.GONE);



            }
        };
    }
}
