package com.bridgelabz.ipl.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgelabz.ipl.R;
import com.bridgelabz.ipl.controller.DownloadImage;
import com.bridgelabz.ipl.intrface.DownloadImageInterface;

public class Player extends AppCompatActivity {
    private TextView p_name,p_dob,p_Batt,p_Bowl,p_nati,p_role;
    private ImageView imageView;
    private Bundle bundle;
    Bitmap bitmap;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        p_name=(TextView)findViewById(R.id.playerN);
        p_Batt=(TextView)findViewById(R.id.playerbatt);
        p_Bowl=(TextView)findViewById(R.id.playerBowl);
        p_dob=(TextView)findViewById(R.id.playdob);
        p_role=(TextView)findViewById(R.id.playRole);
        p_nati=(TextView)findViewById(R.id.playNation);
        imageView=(ImageView)findViewById(R.id.imageView);

        Paint paint = new Paint();
        paint.setAntiAlias(true);


      ///  birdImageView.setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint.setShadowLayer(5, 0, 5, Color.argb(255, 255, 0, 0));
        imageView.setLayerPaint(paint);
        bundle= new Bundle();
        Intent intent=getIntent();
        bundle=intent.getBundleExtra("data");
         String imgurl=bundle.getCharSequence("img").toString();
        DownloadImage.downloadImage(imgurl,new DownloadImageInterface() {
            @Override
            public void getImage(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);

            }
        });
        imageView.setImageBitmap(bitmap);
        p_Batt.setText(bundle.getCharSequence("batting"));
        p_Bowl.setText(bundle.getCharSequence("bowling"));
        p_dob.setText(bundle.getCharSequence("dob"));
        p_role.setText(bundle.getCharSequence("role"));
        p_name.setText(bundle.getCharSequence("name"));
        p_nati.setText(bundle.getCharSequence("notionality"));

        Log.i("player image path", ""+imgurl);

    }
}
