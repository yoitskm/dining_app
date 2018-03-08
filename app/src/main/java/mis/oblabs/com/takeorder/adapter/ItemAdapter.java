package mis.oblabs.com.takeorder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.fragment.ItemFragment;
import mis.oblabs.com.takeorder.pojo.ItemData;
import mis.oblabs.com.takeorder.pojo.ObjItem;
import mis.oblabs.com.takeorder.pojo.OrderData;

/**
 * Created by android on 8/3/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {
    List<ObjItem> list;

    ItemFragment.ItemCallback callback;
    ItemFragment.StateCallback dismissCallback;

    public List<ObjItem> getList() {
        return list;
    }

    public void setList(List<ObjItem> list) {
        this.list = list;
    }

    public ItemAdapter(List<ObjItem> list , ItemFragment.ItemCallback callback) {
        this.list = list;
        this.callback = callback;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        view.setOnClickListener(itemClicked(parent.getContext()));
        return new Holder(view);
    }

    private View.OnClickListener itemClicked(final Context context) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjItem data = list.get((Integer) view.getTag());
                callback.itemSelected(new OrderData(data.getId(),data.getTitle() ,Integer.parseInt(data.getPrice()),1 , 1 ));

                dismissCallback.stateChanged();

            }
        };
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {


        final ObjItem data= list.get(position);

        holder.itemView.setTag(position);


        holder.tvTitle.setText(data.getTitle());
        holder.tvSubTitle.setText(data.getCategory());
        holder.tvKeyword.setText(data.getUnit());
//        holder.tvCount.setText(String.valueOf(data.getCount())+" Orders");
        holder.tvPrice.setText("Rs. "+String.valueOf(data.getPrice()));







    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDismissCallback(ItemFragment.StateCallback callback) {
        this.dismissCallback = callback;
    }

    public class Holder extends RecyclerView.ViewHolder {



        TextView tvTitle,tvSubTitle,tvKeyword,tvCount,tvPrice;
        ImageView imgDish;


        public Holder(View itemView) {
            super(itemView);





            tvTitle = itemView.findViewById(R.id.tvItemTitle);
            tvSubTitle = itemView.findViewById(R.id.tvItemSubTitle);
            tvKeyword = itemView.findViewById(R.id.tvOne);
            tvCount = itemView.findViewById(R.id.tvTwo);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            imgDish = itemView.findViewById(R.id.imgItem);




        }
    }


}
