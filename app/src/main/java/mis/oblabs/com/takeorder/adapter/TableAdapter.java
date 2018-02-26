package mis.oblabs.com.takeorder.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


import mis.oblabs.com.takeorder.R;
import mis.oblabs.com.takeorder.activity.OrderActivity;
import mis.oblabs.com.takeorder.pojo.TableData;

/**
 * Created by android on 8/3/17.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.Holder> {
    List<TableData> list;


    public TableAdapter(List<TableData> list) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_card, parent, false);
        view.setOnClickListener(itemCliked(parent.getContext()));
        return new Holder(view);
    }

    private View.OnClickListener itemCliked(final Context context) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context , OrderActivity.class));

            }
        };
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {






    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class Holder extends RecyclerView.ViewHolder {




        public Holder(View itemView) {
            super(itemView);



        }
    }


}
