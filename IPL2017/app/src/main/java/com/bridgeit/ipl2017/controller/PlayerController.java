package com.bridgeit.ipl2017.controller;

import com.bridgeit.ipl2017.intrface.ArrayListPlayer;
import com.bridgeit.ipl2017.model.PlayerInfoModel;
import com.bridgeit.ipl2017.utility.Debug;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Auth :Sonawane Gokul
 * Date :25/1/2017
 * Disc :this will Load Player data From FireBase claude
 */

public class PlayerController {
    public static final String TAG = "PlayerController";


    private  FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private ArrayList<PlayerInfoModel> mPlayerInfoModels;
    public DatabaseReference getPlayerInfoModels(String teamName,final ArrayListPlayer arrayListdata){

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child(teamName);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<PlayerInfoModel>> t = new GenericTypeIndicator<ArrayList<PlayerInfoModel>>() {
                };
                // whenever data at this location is updated.
                Debug.showLog(TAG,"Geting data..");
                ArrayList<PlayerInfoModel> modelArrayList = new ArrayList<PlayerInfoModel>();
                modelArrayList.addAll(dataSnapshot.getValue(t));
                //return Player data back to the PlayerView Model
                arrayListdata.fireBaseData(modelArrayList);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Debug.showLog(TAG,"Failed To Read Data..");
                // Failed to read value

            }
        });

        return null;
    }
}
