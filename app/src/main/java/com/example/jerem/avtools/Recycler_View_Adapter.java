package com.example.jerem.avtools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerem on 10/14/2016.
 */

public class Recycler_View_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<MyData> data;

    String passingId;
    public Context context;
    public LayoutInflater inflater;
    ArrayList<MyData> filterData;


    //private final List<MyData> data;
   // private List<MyData> filtereddata;


    MyData current;
    int currentPos=0;


    public static final int ITEM_TYPE_LOW = 0;
    public static final int ITEM_TYPE_JET = 1;

    // create constructor to innitilize context and data sent from ListView
    public Recycler_View_Adapter(Context context, List<MyData> data){
        inflater = LayoutInflater.from(context);
        this.context=context;
        this.data=data;

    }

        // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View returnedView;
        if (viewType == ITEM_TYPE_LOW) {
            View lowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout2, parent, false);//null);
//            View lowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout2, parent, false);
            return new MyLowLeadViewHolder(lowView);
            //  MyHolder holder = new MyHolder(view);
        } else if (viewType == ITEM_TYPE_JET) {
            View jetView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);// null);
            return new MyJetViewHolder(jetView);
        }else{
        return null;}
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final int itemType = getItemViewType(position);

        if (itemType == ITEM_TYPE_LOW) {
            MyLowLeadViewHolder myHolder = (MyLowLeadViewHolder) holder;
            myHolder.Textid.setText(Integer.toString(data.get(position).id));
            myHolder.Textpname.setText(data.get(position).pname);
            myHolder.Textptype.setText(data.get(position).ptype);
            myHolder.cardselect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView planeName = (TextView) v.findViewById(R.id.Plname);
                    TextView planeType = (TextView) v.findViewById(R.id.Pltype);
                    Pair<View, String> txtNamePair = Pair.create((View) planeName, "tpname");
                    Pair<View, String> txtTypePair = Pair.create((View) planeType, "tptype");

                    Intent intent = new Intent(v.getContext(), Open_plane.class);

                    MyData current = data.get(position);

                    intent.putExtra("id", Integer.toString(data.get(position).id));
                    intent.putExtra("pname", current.pname);
                    intent.putExtra("ptype", current.ptype);
                    intent.putExtra("pclass", current.pclass);
                    intent.putExtra("pstyle", current.pstyle);
                    intent.putExtra("pnotes", current.pnotes);
                    intent.putExtra("pjetlo", current.pjetlo);

                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(), txtNamePair, txtTypePair);
                    ActivityCompat.startActivity((Activity) v.getContext(), intent, options.toBundle());
                    v.getContext().startActivity(intent, options.toBundle());
                    // v.getContext().startActivity(intent, options.toBundle());

                }
            });

        }else if (itemType == ITEM_TYPE_JET) {
            MyJetViewHolder myHolder = (MyJetViewHolder) holder;
            myHolder.Textid.setText(Integer.toString(data.get(position).id));
            myHolder.Textpname.setText(data.get(position).pname);
            myHolder.Textptype.setText(data.get(position).ptype);
            myHolder.cardselect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView planeName = (TextView) v.findViewById(R.id.Plname);
                    TextView planeType = (TextView) v.findViewById(R.id.Pltype);
                    Pair<View, String> txtNamePair = Pair.create((View) planeName, "tpname");
                    Pair<View, String> txtTypePair = Pair.create((View) planeType, "tptype");

                    Intent intent = new Intent(v.getContext(), Open_plane.class);

                    MyData current = data.get(position);

                    intent.putExtra("id", Integer.toString(data.get(position).id));
                    intent.putExtra("pname", current.pname);
                    intent.putExtra("ptype", current.ptype);
                    intent.putExtra("pclass", current.pclass);
                    intent.putExtra("pstyle", current.pstyle);
                    intent.putExtra("pnotes", current.pnotes);
                    intent.putExtra("pjetlo", current.pjetlo);

                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(), txtNamePair, txtTypePair);
                    ActivityCompat.startActivity((Activity) v.getContext(), intent, options.toBundle());
                    v.getContext().startActivity(intent, options.toBundle());
                }
            });
        }
    }


    @Override
    public int getItemViewType(int position) {
       // String jetLow = "Low Lead";
        if ((data.get(position).pjetlo).equals("Low Lead")) {
            return ITEM_TYPE_LOW;
        } else {
            return ITEM_TYPE_JET;
        }
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();

    }

    public void setFilter(List<MyData> filteredData) {
        filteredData.addAll(filteredData);
        this.notifyDataSetChanged();
    }


    class MyJetViewHolder extends RecyclerView.ViewHolder{

        CardView cardselect;
        TextView Textid;
        TextView Textpname;
        TextView Textptype;

        // create constructor to get widget reference
        public MyJetViewHolder(View itemView) {
            super(itemView);

            cardselect = (CardView) itemView.findViewById(R.id.cardView);
            Textid= (TextView) itemView.findViewById(R.id.hiddenCardId);
            Textpname = (TextView) itemView.findViewById(R.id.Plname);
            Textptype = (TextView) itemView.findViewById(R.id.Pltype);
        }

    }

    class MyLowLeadViewHolder extends RecyclerView.ViewHolder{

        CardView cardselect;
        TextView Textid;
        TextView Textpname;
        TextView Textptype;

        // create constructor to get widget reference
        public MyLowLeadViewHolder(View itemView) {
            super(itemView);

            cardselect = (CardView) itemView.findViewById(R.id.cardView);
            Textid = (TextView) itemView.findViewById(R.id.hiddenCardId);
            Textpname = (TextView) itemView.findViewById(R.id.Plname);
            Textptype = (TextView) itemView.findViewById(R.id.Pltype);
        }

    }




}