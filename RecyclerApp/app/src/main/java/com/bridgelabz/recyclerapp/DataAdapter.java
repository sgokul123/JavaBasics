package com.bridgelabz.recyclerapp;

/**
 * Created by bridgeit on 17/1/17.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> countries;
    private Context context;
    public DataAdapter(ArrayList<String> countries , Context context) {
        this.countries = countries;
        this.context=context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.textViewname.setText(""+i);
        viewHolder.tv_country.setText(countries.get(i));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        private TextView tv_country,textViewname;
        public ViewHolder(View view) {
            super(view);
            textViewname = (TextView) view.findViewById(R.id.tvnamename);
            tv_country = (TextView) view.findViewById(R.id.tv_country);
            tv_country.setOnClickListener(this);
            textViewname.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, EmptyActivity.class);

            switch(view.getId())
            {

                case R.id.tv_country:
                    String s = tv_country.getText().toString();
                intent.putExtra("name", s);
                context.startActivity(intent);
                    break;
                case R.id.tvnamename:
                    String s1 = textViewname.getText().toString();
                    intent.putExtra("name", s1);
                    context.startActivity(intent);

                    break;
                default:
                    break;
            }

        }


    }

}