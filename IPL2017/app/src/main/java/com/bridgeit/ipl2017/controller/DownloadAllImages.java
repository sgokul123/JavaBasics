package com.bridgeit.ipl2017.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.bridgeit.ipl2017.intrface.DownloadAllImageInterface;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by bridgeit on 1/2/17.
 */

public class DownloadAllImages {
    public static final String TAG = "DownloadAllImages";

    public static ArrayList<Bitmap> mBitmap;
    private static int i=0;
   // private  int i=0;

    public static void downloadImage(String url,int size, final DownloadAllImageInterface image) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference reference = storage.getReference().child(url);

        final long IMAGE_SIZE = 1024*1024;
        while(i<size) {
            Log.d("Image_Adapter", "Image Load... "+url);
            reference.child(""+i).getBytes(IMAGE_SIZE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {

                    mBitmap.add(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
                    image.getImage(mBitmap);
                    i=i+1;
                }
            });

        }
    }
}
