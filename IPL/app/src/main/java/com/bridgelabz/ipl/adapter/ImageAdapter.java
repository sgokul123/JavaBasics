package com.bridgelabz.ipl.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by bridgeit on 1/2/17.
 */
public class ImageAdapter extends BaseAdapter {
    private  ImageView imageView;
    private Context mContext;
    private int size,i;
    int j;
    private   ArrayList<Bitmap> bitmaps;
   // private ArrayList<PlayerInfoModel> playerInfoModels=new ArrayList<>();

    public ImageAdapter(Context con, ArrayList<Bitmap> bitmaps) {
        mContext = con;
      this.bitmaps=bitmaps;
    }

    public int getCount() {
        return bitmaps.size();
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
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(255, 255));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        Log.d("Image_Adapter", "Image set ..."+size );

        imageView.setImageBitmap(bitmaps.get(position));

        return imageView;
    }

}