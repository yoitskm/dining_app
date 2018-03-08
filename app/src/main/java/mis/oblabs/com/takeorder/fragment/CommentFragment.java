package mis.oblabs.com.takeorder.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.adapter.HotelAdapter;
import mis.oblabs.com.takeorder.network.ApiRestAdapter;
import mis.oblabs.com.takeorder.pojo.ObjHotel;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.utils.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends DialogFragment {


    public interface StateCallback{
        void stateChanged(String comment);
    }


    CommentFragment.StateCallback callback;

    TextView  tvTitle;
    EditText etComment;
    Button btnAdd;
    String comment;



    public static CommentFragment createInstance(CommentFragment.StateCallback callback , String comment) {
        CommentFragment fragment = new CommentFragment();
        fragment.callback = callback;
        fragment.comment = comment;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.comment_order, container, false);




        etComment = view.findViewById(R.id.etComment);
        etComment.setText(comment);
        btnAdd = view.findViewById(R.id.btnYes);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etComment.getText().toString().equals("")){
                    callback.stateChanged(etComment.getText().toString());
                    dismiss();

                }else{
                    dismiss();
                }
            }
        });












        return view;
    }







}
