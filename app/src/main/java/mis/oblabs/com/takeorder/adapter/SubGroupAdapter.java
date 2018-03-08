package mis.oblabs.com.takeorder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.fragment.ItemFragment;
import mis.oblabs.com.takeorder.fragment.SubGroupFragment;
import mis.oblabs.com.takeorder.pojo.ObjItem;
import mis.oblabs.com.takeorder.pojo.ObjSubGroup;
import mis.oblabs.com.takeorder.pojo.OrderData;

/**
 * Created by android on 8/3/17.
 */

public class SubGroupAdapter extends RecyclerView.Adapter<SubGroupAdapter.Holder> {
    List<ObjSubGroup> list;

    SubGroupFragment.StateCallback dismissCallback;

    public SubGroupAdapter(List<ObjSubGroup> list ) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_card, parent, false);
        view.setOnClickListener(itemClicked(parent.getContext()));
        return new Holder(view);
    }

    private View.OnClickListener itemClicked(final Context context) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismissCallback.stateChanged(view.getTag().toString());

            }
        };
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {


        final ObjSubGroup data= list.get(position);

        holder.itemView.setTag(data.getSubGroupID());


        holder.tvTitle.setText(data.getSubGroupName());









    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDismissCallback(SubGroupFragment.StateCallback callback) {
        this.dismissCallback = callback;
    }

    public class Holder extends RecyclerView.ViewHolder {



        TextView tvTitle,tvSubTitle,tvKeyword,tvCount,tvPrice;
        ImageView imgDish;


        public Holder(View itemView) {
            super(itemView);





            tvTitle = itemView.findViewById(R.id.tvItemTitle);





        }
    }


}
