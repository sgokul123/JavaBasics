package com.bridgelabz.ipl.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.ipl.R;
import com.bridgelabz.ipl.controller.DownloadImage;
import com.bridgelabz.ipl.intrface.DownloadImageInterface;
import com.bridgelabz.ipl.model.TeamInfoModel;

import java.util.List;

/**
 * Created by bridgeit on 27/1/17.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {

    private List<TeamInfoModel> teamList;
    private Context mContext;
    private int lastPosition = -1;
    Animation animation;

    public TeamAdapter(List<TeamInfoModel> teamList,Context context) {
        Log.i("team adapter ", "  class");
        this.mContext = context;
        this.teamList =teamList;
    }
    @Override
    public TeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_display_card, parent, false);
        //  itemView.setOnClickListener(this);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int i) {

        //retribe data for single team

        TeamInfoModel model = teamList.get(i);

        //set team  data

        holder.t_team_name.setText(model.getTeamname());
        holder.t_owner.setText(model.getOwner());
        //Initialise Animatin  and assign to each card with data
        animation = AnimationUtils.loadAnimation(mContext.getApplicationContext(), R.anim.slide_down);
        holder.teamcardView.setAnimation(animation);
        holder.teamcardView.startAnimation(animation);
        Log.d("Adapter", "Value added.. " +model.getUrl());
        DownloadImage.downloadImage(model.getUrl(), new DownloadImageInterface() {
            @Override
            public void getImage(Bitmap bitmap) {
                holder.t_url.setImageBitmap(bitmap);
            }
        });

        Log.d("Adapter", "Image Loaded.. " );
    }




    @Override
    public int getItemCount() {
        return teamList.size();
    }


    //
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView t_owner,t_team_name;
        ImageView t_url;
        CardView teamcardView;
        public MyViewHolder(View view) {
            super(view);

            teamcardView=(CardView)view.findViewById(R.id.teamCard);
            t_owner = (TextView) view.findViewById(R.id.teamOwner);
            t_team_name = (TextView) view.findViewById(R.id.teamName);
            t_url = (ImageView) view.findViewById(R.id.imgurl);
            t_url.setOnClickListener(this);
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
