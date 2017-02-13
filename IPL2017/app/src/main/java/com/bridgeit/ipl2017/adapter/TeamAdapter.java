package com.bridgeit.ipl2017.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgeit.ipl2017.R;
import com.bridgeit.ipl2017.controller.DownloadImage;
import com.bridgeit.ipl2017.intrface.DownloadImageInterface;
import com.bridgeit.ipl2017.model.TeamInfoModel;
import com.bridgeit.ipl2017.utility.Debug;

import java.util.List;


/**
 * Created by bridgeit on 27/1/17.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    public static final String TAG = "TeamAdapter";
    Animation mAnimation;
    private List<TeamInfoModel> mTeamList;
    private Context mContext;
    private int lastPosition = -1;

    public TeamAdapter(List<TeamInfoModel> teamList, Context context) {
        Debug.showLog(TAG,"constructor..");
        this.mContext = context;
        this.mTeamList =teamList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_display_card, parent, false);
        //  itemView.setOnClickListener(this);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int i) {

        //retribe data for single team

        TeamInfoModel model = mTeamList.get(i);

        //set team  data

        holder.t_team_name.setText(model.getTeamname());
        holder.t_owner.setText(model.getOwner());
        //Initialise Animatin  and assign to each card with data
        mAnimation = AnimationUtils.loadAnimation(mContext.getApplicationContext(), R.anim.slide_down);
        holder.teamcardView.setAnimation(mAnimation);
        holder.teamcardView.startAnimation(mAnimation);
        Debug.showLog(TAG,"Value Added.."+model.getUrl());
        DownloadImage.downloadImage(model.getUrl(), new DownloadImageInterface() {
            @Override
            public void getImage(Bitmap bitmap) {
                holder.t_url.setImageBitmap(bitmap);
            }
        });
        Debug.showLog(TAG,"Image Loaded...");
    }

    @Override
    public int getItemCount() {
        return mTeamList.size();
    }

    //
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        public TextView t_owner,t_team_name;
        ImageView t_url;
        CardView teamcardView;

        public MyViewHolder(View view) {
            super(view);

            teamcardView=(CardView)view.findViewById(R.id.team_card);
            t_owner = (TextView) view.findViewById(R.id.textview_team_owner);
            t_team_name = (TextView) view.findViewById(R.id.textview_team_name);
            t_url = (ImageView) view.findViewById(R.id.imageview_teamcard_imgurl);
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
