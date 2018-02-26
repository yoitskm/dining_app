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
import android.widget.TextView;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.adapter.ItemAdapter;
import mis.oblabs.com.takeorder.adapter.OrderItemAdapter;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Constants;

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

    TextView tvFilter , tvAdd;
    EditText etSearch;
    RecyclerView recyclerView;
    ItemAdapter adapter;

    public static ItemFragment createInstance(ItemCallback callback) {
        ItemFragment fragment = new ItemFragment();
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
        etSearch = view.findViewById(R.id.etSearch);
        recyclerView = view.findViewById(R.id.recycle_item);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ItemAdapter(Constants.getItems(), callback);
        adapter.setDismissCallback(new StateCallback() {
            @Override
            public void stateChanged() {
                dismiss();
            }
        });
        recyclerView.setAdapter(adapter);


        return view;
    }

}
