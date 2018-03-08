package mis.oblabs.com.takeorder.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.adapter.ItemAdapter;
import mis.oblabs.com.takeorder.adapter.SubGroupAdapter;
import mis.oblabs.com.takeorder.network.ApiRestAdapter;
import mis.oblabs.com.takeorder.pojo.ObjItem;
import mis.oblabs.com.takeorder.pojo.ObjSubGroup;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubGroupFragment extends DialogFragment {

    public interface ItemCallback{
        void itemSelected(OrderData data);



    }
    public interface StateCallback{
        void stateChanged(String id);
    }


    ItemFragment.ItemCallback callback;

    TextView tvFilter , tvAdd , tvTitle;
    EditText etSearch;
    RecyclerView recyclerView;
    SubGroupAdapter adapter;
    ProgressBar progressBar;

    public static SubGroupFragment createInstance(ItemFragment.ItemCallback callback) {
        SubGroupFragment fragment = new SubGroupFragment();
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
        tvTitle.setText("Select Sub Group");
        etSearch = view.findViewById(R.id.etSearch);
        recyclerView = view.findViewById(R.id.recycle_item);
        progressBar = view.findViewById(R.id.progressbar);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter = new ItemAdapter(Constants.getItems(), callback);


        loadItems();


        return view;
    }

    private void loadItems() {
//        Helper.showLoading(getContext() , "Loading Items...");




        new ApiRestAdapter().getSubGroups().enqueue(new Callback<List<ObjSubGroup>>() {
            @Override
            public void onResponse(Call<List<ObjSubGroup>> call, Response<List<ObjSubGroup>> response) {
                progressBar.setVisibility(View.GONE);
                if(response.code()==200) {
                    adapter = new SubGroupAdapter(response.body());
                    adapter.setDismissCallback(new StateCallback() {
                        @Override
                        public void stateChanged(String id) {
                            ItemFragment fragment = ItemFragment.createInstance(callback , id);
                            fragment.show(getFragmentManager() , "items");
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
            public void onFailure(Call<List<ObjSubGroup>> call, Throwable t) {
                Helper.showLongToast(getContext() , "Failed");

                dismiss();

                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
