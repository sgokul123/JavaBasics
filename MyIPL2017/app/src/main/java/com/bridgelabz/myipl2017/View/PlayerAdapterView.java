package com.bridgelabz.myipl2017.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bridgelabz.myipl2017.Model.PlayerInfoModel;
import com.bridgelabz.myipl2017.R;

import java.util.List;

/**
 * Created by bridgeit on 18/1/17.
 */

public class PlayerAdapterView extends RecyclerView.Adapter<PlayerAdapterView.MyViewHolder> implements View.OnClickListener,View.OnLongClickListener {

    private List<PlayerInfoModel> playerList;
    private Context mContext;

    public PlayerAdapterView(Context context, List<PlayerInfoModel> playerListList) {
        this.mContext = context;
        this.playerList =playerListList;
    }

    @Override
    public PlayerAdapterView.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list_card, parent, false);
        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(PlayerAdapterView.MyViewHolder holder, int i) {

        holder.p_bowl_style.setText(playerList.get(i).getPlayer_bowling_style());
        holder.p_bat_style.setText(playerList.get(i).getPlayer_batting_style());
        holder.p_dob.setText(playerList.get(i).getPlayer_dob());
        holder.p_name.setText(playerList.get(i).getPlayer_name());
        holder.p_nationality.setText(playerList.get(i).getPlayer_nationality());
        holder.p_role.setText(playerList.get(i).getPlayer_role());
        holder.d_folder_name.setText(playerList.get(i).getDestination_folder_name());
        Log.d("Adapter", "Value added.. " );

    }


    @Override
    public int getItemCount() {
        return playerList.size();
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(mContext.getApplicationContext(),"",Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView d_folder_name, p_bowl_style,p_bat_style, p_dob,p_name,p_nationality,p_role;
       ImageView imageView1;
        public MyViewHolder(View view) {
            super(view);
            imageView1=(ImageView)view.findViewById(R.id.imageView) ;
            p_bowl_style = (TextView) view.findViewById(R.id.p_bowl_style);
            p_bat_style = (TextView) view.findViewById(R.id.p_bat_style);
            p_dob = (TextView) view.findViewById(R.id.p_dob);
            p_name = (TextView) view.findViewById(R.id.p_name);
            p_nationality = (TextView) view.findViewById(R.id.p_nationality);
            p_role = (TextView) view.findViewById(R.id.p_role);
            //p_bowl_style.setText(playerList.get(1).toString());

            imageView1.setOnClickListener(this);
        }



        @Override
        public void onClick(View view) {
         //   Toast.makeText(mContext,p_dob.getText().toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
