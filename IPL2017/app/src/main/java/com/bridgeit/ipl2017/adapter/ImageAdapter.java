package com.bridgeit.ipl2017.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bridgeit.ipl2017.utility.Debug;

import java.util.ArrayList;

/**
 * Created by bridgeit on 1/2/17.
 */
public class ImageAdapter extends BaseAdapter {
    public static final String TAG = "ImageAdapter";

    private  ImageView mImageView;
    private Context mContext;
    private int size,i;
    int j;
    private   ArrayList<Bitmap> mBitmapsImages;
   // private ArrayList<PlayerInfoModel> playerInfoModels=new ArrayList<>();

    public ImageAdapter(Context con, ArrayList<Bitmap> bitmaps) {
        mContext = con;
      this.mBitmapsImages =bitmaps;
    }

    public int getCount() {
        return mBitmapsImages.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            mImageView = new ImageView(mContext);
            mImageView.setLayoutParams(new GridView.LayoutParams(255, 255));
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setPadding(8, 8, 8, 8);
        } else {
            mImageView = (ImageView) convertView;
        }
        Debug.showLog(TAG,"Set Image..");
        mImageView.setImageBitmap(mBitmapsImages.get(position));

        return mImageView;
    }

}