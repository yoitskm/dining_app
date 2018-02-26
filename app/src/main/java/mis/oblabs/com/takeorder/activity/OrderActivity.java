package mis.oblabs.com.takeorder.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.adapter.OrderItemAdapter;
import mis.oblabs.com.takeorder.adapter.TableAdapter;
import mis.oblabs.com.takeorder.fragment.ItemFragment;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Constants;

public class OrderActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Button bttnCheckout;
    FloatingActionButton bttnAdd;
    OrderItemAdapter orderItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = findViewById(R.id.recycle_orders);
        bttnCheckout = findViewById(R.id.bttnCheckout);
        bttnAdd = findViewById(R.id.bttnAdd);

        bttnAdd.setOnClickListener(newItemAddClicked());


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        orderItemAdapter = new OrderItemAdapter(Constants.getOrders());
        recyclerView.setAdapter(orderItemAdapter);
    }

    private View.OnClickListener newItemAddClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ItemFragment fragment = ItemFragment.createInstance(itemCallback());
                fragment.show(getSupportFragmentManager() , "Title");

//                getSupportFragmentManager().beginTransaction().add(R.id.frame, ItemFragment.createInstance(itemCallback())).addToBackStack(null).commit();

            }
        };
    }

    private ItemFragment.ItemCallback itemCallback() {
        return new ItemFragment.ItemCallback() {
            @Override
            public void itemSelected(OrderData data) {

                orderItemAdapter.addItemInList(data);



            }
        };
    }
}
