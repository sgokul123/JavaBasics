package com.bridgelabz.ipl.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bridgelabz.ipl.R;
import com.bridgelabz.ipl.adapter.ImageAdapter;
import com.bridgelabz.ipl.controller.DownloadAllImages;
import com.bridgelabz.ipl.intrface.ArrayListPlayer;
import com.bridgelabz.ipl.intrface.DownloadAllImageInterface;
import com.bridgelabz.ipl.model.PlayerInfoModel;
import com.bridgelabz.ipl.viewModel.PlayerViewModel;

import java.util.ArrayList;

public class PlayerImageGrid extends AppCompatActivity {
    private GridView gridView;
    private ImageView[] imagegrid;
    private CardView cardView[];
    private int i, size, j = 0;
    private ArrayList<Bitmap> bitmaps;

    private ProgressDialog mDialog;
    private ArrayList<PlayerInfoModel> playerInfoModels = new ArrayList<>();
    private String teamName;
    Intent intent;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_image_grid);
        gridView = (GridView) findViewById(R.id.gridview);

        intent = getIntent();
        teamName = intent.getStringExtra("team");

        PlayerViewModel playerViewModel = new PlayerViewModel(getApplicationContext());

        playerViewModel.getPlayerData(teamName, new ArrayListPlayer() {
            @Override
            public void fireBaseData(ArrayList<PlayerInfoModel> playerInfo) {
                //showProgress();
                playerInfoModels = playerInfo;
                size = playerInfoModels.size();
                bitmaps = new ArrayList<Bitmap>();
                Log.d("Player_Grid", "Get Grid... " + size);
               DownloadAllImages.downloadImage(teamName,size, new DownloadAllImageInterface() {
                    @Override
                    public void getImage(ArrayList<Bitmap> bitmap) {
                        Log.d("Image_Adapter", "Image Load... " + j);
                        bitmaps = bitmap;
                        gridView.setAdapter(new ImageAdapter(getApplicationContext(),bitmaps));
                    }
                });
               // mDialog.dismiss();

            }

        });
        // mDialog.dismiss();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(PlayerImageGrid.this, "Image ..." + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
  /*  public void showProgress() {
        mDialog  = new ProgressDialog(getApplicationContext());
        mDialog.setMessage("Downloading Player Images...");
        mDialog.setCancelable(false);
        mDialog.show();
    }*/
}
