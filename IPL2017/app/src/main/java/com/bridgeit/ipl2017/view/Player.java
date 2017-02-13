package com.bridgeit.ipl2017.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridgeit.ipl2017.R;
import com.bridgeit.ipl2017.controller.DownloadImage;
import com.bridgeit.ipl2017.intrface.DownloadImageInterface;
import com.bridgeit.ipl2017.utility.Constants;
import com.bridgeit.ipl2017.utility.Debug;


public class Player extends AppCompatActivity {
    public static final String TAG = "Player";
    Bitmap mBitmapImage;
    private TextView mTextViewPName,p_dob, mTextViewP_Batt, mTextViewP_Bowl, mTextViewP_Nati, mTextViewP_Role;
    private ImageView mImageViewPlayer;
    private Bundle mBundleData;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mTextViewPName=(TextView)findViewById(R.id.textview_player_name);
        mTextViewP_Batt =(TextView)findViewById(R.id.textview_player_batt);
        mTextViewP_Bowl =(TextView)findViewById(R.id.textview_player_bowl);
        p_dob=(TextView)findViewById(R.id.textview_player_dob);
        mTextViewP_Role =(TextView)findViewById(R.id.textview_play_role);
        mTextViewP_Nati =(TextView)findViewById(R.id.textview_player_nation);
        mImageViewPlayer =(ImageView)findViewById(R.id.imageView_player_Image);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        ///  birdImageView.setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint.setShadowLayer(5, 0, 5, Color.argb(255, 255, 0, 0));
        mImageViewPlayer.setLayerPaint(paint);
        mBundleData = new Bundle();
        Intent intent=getIntent();
        mBundleData =intent.getBundleExtra(Constants.BundleKeys.DATA);
        String imgurl= mBundleData.getCharSequence(Constants.BundleKeys.IMG).toString();
        DownloadImage.downloadImage(imgurl,new DownloadImageInterface() {
            @Override
            public void getImage(Bitmap bitmap) {
                mImageViewPlayer.setImageBitmap(bitmap);

            }
        });
        mImageViewPlayer.setImageBitmap(mBitmapImage);
        mTextViewP_Batt.setText(mBundleData.getCharSequence(Constants.BundleKeys.BATTING));
        mTextViewP_Bowl.setText(mBundleData.getCharSequence(Constants.BundleKeys.BOWLING));
        p_dob.setText(mBundleData.getCharSequence(Constants.BundleKeys.DOB));
        mTextViewP_Role.setText(mBundleData.getCharSequence(Constants.BundleKeys.ROLE));
        mTextViewPName.setText(mBundleData.getCharSequence(Constants.BundleKeys.NAME));
        mTextViewP_Nati.setText(mBundleData.getCharSequence(Constants.BundleKeys.NATIONALITY));
        Debug.showLog(TAG," "+imgurl);
    }
}
