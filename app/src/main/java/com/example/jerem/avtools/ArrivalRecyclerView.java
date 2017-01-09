package com.example.jerem.avtools;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by jerem on 1/2/2017.
 */

public class ArrivalRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<TableData> data= Collections.emptyList();

    public ArrivalRecyclerView(Context context, List<TableData> data){
        inflater = LayoutInflater.from(context);
        this.context=context;
        this.data=data;
    }

    @Override
    public ArrivalRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tablerowcardview, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder myHolder = (ViewHolder) holder;
/*        myHolder.txType.setText(data.get(position).AcType);
        myHolder.txArrival.setText(data.get(position).Arrl);
        myHolder.txEta.setText(data.get(position).ETA);
        myHolder.txFuelEst.setText(data.get(position).Fuel);*/
        myHolder.cardsSelect.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), listviewmain.class);
                v.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardsSelect;
        TextView txType;
        TextView txEta;
        TextView txArrival;
        TextView txFuelEst;

        public ViewHolder(View itemView){
                super(itemView);
            cardsSelect=(CardView)itemView.findViewById(R.id.cardViewTraqTableRow);
            txType=(TextView)itemView.findViewById(R.id.TdType);
            txArrival=(TextView)itemView.findViewById(R.id.TdArrivaltime);
            txEta=(TextView)itemView.findViewById(R.id.TdEta);
            txFuelEst=(TextView)itemView.findViewById(R.id.TdEstemateFuel);
        }
    }


}
