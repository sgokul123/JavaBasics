package com.bridgeit.ipl2017.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bridgeit.ipl2017.R;
import com.bridgeit.ipl2017.controller.DownloadImage;
import com.bridgeit.ipl2017.intrface.DownloadImageInterface;
import com.bridgeit.ipl2017.model.PlayerInfoModel;
import com.bridgeit.ipl2017.utility.Constants;
import com.bridgeit.ipl2017.utility.Debug;
import com.bridgeit.ipl2017.view.Player;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by bridgeit on 27/1/17.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> implements View.OnClickListener,View.OnLongClickListener {
    public static final String TAG = "PlayerAdapter";

    ByteArrayOutputStream mByteArrayStream = new ByteArrayOutputStream();
    Animation mAnimation;
    int j,size;
    ProgressDialog mDialog;
    private List<PlayerInfoModel> playerList;
    //private ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>(30);
    private Context mContext;
    public PlayerAdapter( List<PlayerInfoModel> playerList,Context context,  ProgressDialog mDialog) {
        this.mContext = context;
        this.playerList =playerList;
        this.mDialog=mDialog;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_display_card, parent, false);
        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {
        PlayerInfoModel model = playerList.get(i);

       /* holder.p_bowl_style.setText(model.getPlayer_bowling_style());
        holder.p_bat_style.setText(model.getPlayer_batting_style());
        holder.p_dob.setText(model.getPlayer_dob());

        holder.p_nationality.setText(model.getPlayer_nationality());
        holder.p_role.setText(model.getPlayer_role());*/

        holder.p_name.setText(model.getPlayer_name());

        // Assign Animattion to each card.
        mAnimation = AnimationUtils.loadAnimation(mContext, R.anim.fade_in);
        holder.playercardView.setAnimation(mAnimation);
        holder.playercardView.startAnimation(mAnimation);

        //Download Images and assign to ImageView .
        DownloadImage.downloadImage(model.getPlayer_img_url(), new DownloadImageInterface() {
            @Override
            public void getImage(Bitmap bitmap) {
                holder.playerImg.setImageBitmap(bitmap);
                //      bitmaps.add(i,bitmap);

            }
        });

        mDialog.dismiss();
        Debug.showLog(TAG,"Image Loaded..");
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

            playercardView=(CardView)view.findViewById(R.id.player_card);
            playerImg=(ImageView)view.findViewById(R.id.imageview_card_image) ;
            p_name = (TextView) view.findViewById(R.id.textview_player_name);
            //  p_name.setBackgroundColor(R.color.CandyAppleRed);
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

            mAnimation =AnimationUtils.loadAnimation(mContext,R.anim.bounce);
            playercardView.setAnimation(mAnimation);
            playercardView.startAnimation(mAnimation);
            ///  PlayerInfoModel model =playerList.get(i);
            Debug.showLog(TAG,"onClick...");
            int i=getLayoutPosition();
            PlayerInfoModel model = playerList.get(i);
            Bundle bundle = new Bundle();
            bundle.putString(Constants.BundleKeys.NAME, model.getPlayer_name());
            bundle.putString(Constants.BundleKeys.DOB,model.getPlayer_dob());
            bundle.putString(Constants.BundleKeys.ROLE, model.getPlayer_role());
            bundle.putString(Constants.BundleKeys.BATTING, model.getPlayer_batting_style());
            bundle.putString(Constants.BundleKeys.BOWLING, model.getPlayer_bowling_style());
            bundle.putString(Constants.BundleKeys.NATIONALITY, model.getPlayer_nationality());
            bundle.putString(Constants.BundleKeys.IMG, model.getPlayer_img_url());

            Intent intent = new Intent(mContext.getApplicationContext(), Player.class);
            intent.putExtra(Constants.BundleKeys.DATA,bundle);

            mContext.startActivity(intent);
            //   Toast.makeText(mContext,p_dob.getText().toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
