package mis.oblabs.com.takeorder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.pojo.OrderData;
import mis.oblabs.com.takeorder.pojo.TableData;

/**
 * Created by android on 8/3/17.
 */

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.Holder> {
    List<OrderData> list;

    public List<OrderData> getList() {
        return list;
    }


    public void addItemInList(OrderData data){

        list.add(data);
        notifyDataSetChanged();

    }

    public OrderItemAdapter(List<OrderData> list) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card, parent, false));
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {


        final OrderData data= list.get(position);



        holder.tvSn.setText(""+(position+1));
        holder.tvTitle.setText(data.getItemName());
        holder.tvQuantity.setText("x"+String.valueOf(data.getCount()));
        holder.tvAmount.setText("Rs. "+String.valueOf(data.getPrice()));
        holder.tvTotal.setText("Rs. "+String.valueOf(data.getCount()*data.getPrice()));

        holder.tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setCount(data.getCount()+1);
                holder.tvCount.setText(String.valueOf(data.getCount()));
                holder.tvQuantity.setText(String.valueOf(data.getCount()));
                holder.tvTotal.setText("Rs. "+String.valueOf(data.getCount()*data.getPrice()));
            }
        });


        holder.tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setCount(data.getCount()-1);
                if(data.getCount()==0){
                    list.remove(position);
                    notifyDataSetChanged();
                    return;

                }
                holder.tvCount.setText(String.valueOf(data.getCount()));
                holder.tvQuantity.setText(String.valueOf(data.getCount()));
                holder.tvTotal.setText("Rs. "+String.valueOf(data.getCount()*data.getPrice()));

            }
        });

        holder.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list.remove(position);
                notifyDataSetChanged();

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {



        TextView tvSn , tvTitle , tvPlus , tvMinus , tvCount , tvCancel , tvAmount , tvTotal  ,tvQuantity;


        public Holder(View itemView) {
            super(itemView);


            tvSn = itemView.findViewById(R.id.tvSn);
            tvTitle = itemView.findViewById(R.id.tvItemName);
            tvPlus = itemView.findViewById(R.id.tvPlus);
            tvMinus = itemView.findViewById(R.id.tvMinus);
            tvCount = itemView.findViewById(R.id.tvCount);
            tvCancel = itemView.findViewById(R.id.tvCancel);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);



        }
    }


}
