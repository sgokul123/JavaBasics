package com.bridgelabz.ipl.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import android.widget.Toast;

import com.bridgelabz.ipl.R;
import com.bridgelabz.ipl.controller.DownloadImage;
import com.bridgelabz.ipl.intrface.DownloadImageInterface;
import com.bridgelabz.ipl.model.PlayerInfoModel;
import com.bridgelabz.ipl.view.Player;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by bridgeit on 27/1/17.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> implements View.OnClickListener,View.OnLongClickListener {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    private List<PlayerInfoModel> playerList;
    //private ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>(30);
    private Context mContext;
    Animation animation;
    int j,size;
    ProgressDialog mDialog;
    public PlayerAdapter( List<PlayerInfoModel> playerList,Context context,  ProgressDialog mDialog) {
        this.mContext = context;
        this.playerList =playerList;
        this.mDialog=mDialog;



    }

    @Override
    public PlayerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_display_card, parent, false);
        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final PlayerAdapter.MyViewHolder holder, final int i) {
        PlayerInfoModel model = playerList.get(i);

       /* holder.p_bowl_style.setText(model.getPlayer_bowling_style());
        holder.p_bat_style.setText(model.getPlayer_batting_style());
        holder.p_dob.setText(model.getPlayer_dob());

        holder.p_nationality.setText(model.getPlayer_nationality());
        holder.p_role.setText(model.getPlayer_role());*/

        holder.p_name.setText(model.getPlayer_name());

        // Assign Animattion to each card.
        animation= AnimationUtils.loadAnimation(mContext,R.anim.fade_in);
        holder.playercardView.setAnimation(animation);
        holder.playercardView.startAnimation(animation);

        //Download Images and assign to ImageView .
        DownloadImage.downloadImage(model.getPlayer_img_url(), new DownloadImageInterface() {
            @Override
            public void getImage(Bitmap bitmap) {
                holder.playerImg.setImageBitmap(bitmap);
          //      bitmaps.add(i,bitmap);

            }
        });

        mDialog.dismiss();
        Log.d("Player_Adapter", "Image Loaded.. " );

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
       public TextView p_name;//,p_nationality,p_role,d_folder_name, p_bowl_style,p_bat_style, p_dob,;
        ImageView playerImg;
        CardView playercardView;
        public MyViewHolder(View view) {
            super(view);

            playercardView=(CardView)view.findViewById(R.id.playerCard);
            playerImg=(ImageView)view.findViewById(R.id.playerImage) ;
            p_name = (TextView) view.findViewById(R.id.playerName);
           /* p_bowl_style = (TextView) view.findViewById(R.id.playerBowlingStyle);
            p_bat_style = (TextView) view.findViewById(R.id.playerBattingStyle);
            p_dob = (TextView) view.findViewById(R.id.playerdob);

            p_nationality = (TextView) view.findViewById(R.id.playerNationality);
            p_role = (TextView) view.findViewById(R.id.playerrole);*/
            //p_bowl_style.setText(playerList.get(1).toString());

           playercardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            animation=AnimationUtils.loadAnimation(mContext,R.anim.bounce);
            playercardView.setAnimation(animation);
            playercardView.startAnimation(animation);
          ///  PlayerInfoModel model =playerList.get(i);
            Log.i("postion player", "");
            int i=getLayoutPosition();
            PlayerInfoModel model = playerList.get(i);
            Bundle bundle = new Bundle();
            bundle.putString("name", model.getPlayer_name());
            bundle.putString("dob",model.getPlayer_dob());
            bundle.putString("role", model.getPlayer_role());
            bundle.putString("batting", model.getPlayer_batting_style());
            bundle.putString("bowling", model.getPlayer_bowling_style());
            bundle.putString("notionality", model.getPlayer_nationality());
            bundle.putString("img", model.getPlayer_img_url());

            Intent intent = new Intent(mContext.getApplicationContext(), Player.class);
            intent.putExtra("data",bundle);

            mContext.startActivity(intent);
            //   Toast.makeText(mContext,p_dob.getText().toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
