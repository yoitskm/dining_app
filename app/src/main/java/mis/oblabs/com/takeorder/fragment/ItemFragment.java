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
import mis.oblabs.com.takeorder.adapter.ItemAdapter;
import mis.oblabs.com.takeorder.adapter.OrderItemAdapter;
import mis.oblabs.com.takeorder.network.ApiRestAdapter;
import mis.oblabs.com.takeorder.pojo.ItemData;
import mis.oblabs.com.takeorder.pojo.ObjItem;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Constants;
import mis.oblabs.com.takeorder.utils.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends DialogFragment {

    public interface ItemCallback{
        void itemSelected(OrderData data);



    }
    public interface StateCallback{
        void stateChanged();
    }


    ItemCallback callback;

    TextView tvFilter , tvAdd , tvTitle;
    EditText etSearch;
    RecyclerView recyclerView;
    ItemAdapter adapter;
    ProgressBar progressBar;
    String subGrpId;

    List<ObjItem> items;

    public static ItemFragment createInstance(ItemCallback callback, String subGrpId) {
        ItemFragment fragment = new ItemFragment();
        fragment.callback = callback;
        fragment.subGrpId = subGrpId;
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
        tvTitle.setText("Select Item");
        etSearch = view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.VISIBLE);
        etSearch.addTextChangedListener(searchItemWatcher());
        recyclerView = view.findViewById(R.id.recycle_item);
        progressBar = view.findViewById(R.id.progressbar);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter = new ItemAdapter(Constants.getItems(), callback);


        loadItems();


        return view;
    }

    private TextWatcher searchItemWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String searchItem = editable.toString();
                updateItemList(searchItem);


            }
        };
    }

    private void updateItemList(String searchItem) {


        if(adapter!=null) {

            List<ObjItem> updatedItems = new ArrayList<>();
            for (ObjItem item:items) {

                if(item.getTitle().contains(searchItem.toUpperCase())){
                    updatedItems.add(item);



                }
            }


            adapter.setList(updatedItems);

            adapter.notifyDataSetChanged();


        }
    }

    private void loadItems() {
//        Helper.showLoading(getContext() , "Loading Items...");




        new ApiRestAdapter().getItems(subGrpId).enqueue(new Callback<List<ObjItem>>() {
            @Override
            public void onResponse(Call<List<ObjItem>> call, Response<List<ObjItem>> response) {
                progressBar.setVisibility(View.GONE);
                if(response.code()==200) {

                    items = response.body();
                    adapter = new ItemAdapter(response.body(), callback);
                    adapter.setDismissCallback(new StateCallback() {
                        @Override
                        public void stateChanged() {
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
            public void onFailure(Call<List<ObjItem>> call, Throwable t) {
                Helper.showLongToast(getContext() , "Failed");

                dismiss();

                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
