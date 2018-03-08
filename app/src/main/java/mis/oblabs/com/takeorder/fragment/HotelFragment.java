package mis.oblabs.com.takeorder.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.adapter.HotelAdapter;
import mis.oblabs.com.takeorder.adapter.ItemAdapter;
import mis.oblabs.com.takeorder.network.ApiRestAdapter;
import mis.oblabs.com.takeorder.pojo.ObjHotel;
import mis.oblabs.com.takeorder.pojo.ObjItem;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends DialogFragment {

    public interface ItemCallback{
        void itemSelected(OrderData data);



    }
    public interface StateCallback{
        void stateChanged(String hotelID);
    }


    HotelFragment.ItemCallback callback;

    TextView tvFilter , tvAdd , tvTitle;
    EditText etSearch;
    RecyclerView recyclerView;
    HotelAdapter adapter;
    ProgressBar progressBar;



    public static HotelFragment createInstance(HotelFragment.ItemCallback callback) {
        HotelFragment fragment = new HotelFragment();
        fragment.callback = callback;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);


        tvAdd = view.findViewById(R.id.tvAdd);
        tvFilter = view.findViewById(R.id.tvFilter);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText("Select Restaurant");
        etSearch = view.findViewById(R.id.etSearch);


        recyclerView = view.findViewById(R.id.recycle_item);
        progressBar = view.findViewById(R.id.progressbar);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter = new ItemAdapter(Constants.getItems(), callback);


        loadItems();


        return view;
    }



    private void updateItemList(String searchItem) {

//
//        if(adapter!=null) {
//
//            List<ObjItem> updatedItems = new ArrayList<>();
//            for (ObjItem item:items) {
//
//                if(item.getTitle().contains(searchItem.toUpperCase())){
//                    updatedItems.add(item);
//
//
//
//                }
//            }
//
//
//            adapter.setList(updatedItems);
//
//            adapter.notifyDataSetChanged();
//
//
//        }
    }

    private void loadItems() {
//        Helper.showLoading(getContext() , "Loading Items...");




        new ApiRestAdapter().getHotels().enqueue(new Callback<List<ObjHotel>>() {
            @Override
            public void onResponse(Call<List<ObjHotel>> call, Response<List<ObjHotel>> response) {
                progressBar.setVisibility(View.GONE);
                if(response.code()==200) {


                    adapter = new HotelAdapter(response.body());
                    adapter.setDismissCallback(new StateCallback() {
                        @Override
                        public void stateChanged(String hotelID) {
                            dismiss();
                        }
                    });
                    recyclerView.setAdapter(adapter);
                }else{
                    Helper.showLongToast(getContext() , "No Data Found");
                    dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<ObjHotel>> call, Throwable t) {
                Helper.showLongToast(getContext() , "Failed");

                dismiss();

                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
