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
import mis.oblabs.com.takeorder.adapter.GroupAdapter;
import mis.oblabs.com.takeorder.adapter.ItemAdapter;
import mis.oblabs.com.takeorder.network.ApiRestAdapter;
import mis.oblabs.com.takeorder.pojo.ObjGroup;
import mis.oblabs.com.takeorder.pojo.ObjItem;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends DialogFragment {

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
    GroupAdapter adapter;
    ProgressBar progressBar;

    public static GroupFragment createInstance(ItemFragment.ItemCallback callback) {
        GroupFragment fragment = new GroupFragment();
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
        tvFilter = view.findViewById(R.id.tvTitle);
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




        new ApiRestAdapter().getGroups().enqueue(new Callback<List<ObjGroup>>() {
            @Override
            public void onResponse(Call<List<ObjGroup>> call, Response<List<ObjGroup>> response) {
                progressBar.setVisibility(View.GONE);
                if(response.code()==200) {
                    adapter = new GroupAdapter(response.body());
                    adapter.setDismissCallback(new StateCallback() {
                        @Override
                        public void stateChanged(String id) {

                            SubGroupFragment fragment = SubGroupFragment.createInstance(callback);
                            fragment.show(getFragmentManager() , "groups");
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
            public void onFailure(Call<List<ObjGroup>> call, Throwable t) {
                Helper.showLongToast(getContext() , "Failed");

                dismiss();

                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
