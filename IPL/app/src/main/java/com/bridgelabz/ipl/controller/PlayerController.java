package com.bridgelabz.ipl.controller;

import android.util.Log;

import com.bridgelabz.ipl.intrface.ArrayListPlayer;
import com.bridgelabz.ipl.model.PlayerInfoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by bridgeit on 27/1/17.
 */

public class PlayerController {

    private  FirebaseDatabase database ;
    private DatabaseReference myRef ;
    private ArrayList<PlayerInfoModel> playerInfoModels;
    public DatabaseReference getPlayerInfoModels(String teamName,final ArrayListPlayer arrayListdata){

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child(teamName);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<PlayerInfoModel>> t = new GenericTypeIndicator<ArrayList<PlayerInfoModel>>() {
                };  // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d("Player_Controller", "Value is: " );
                ArrayList<PlayerInfoModel> modelArrayList = new ArrayList<PlayerInfoModel>();
                modelArrayList.addAll(dataSnapshot.getValue(t));
                Log.d("Player_Controller", "Value is: " );
                arrayListdata.fireBaseData(modelArrayList);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Player_Controller", "Failed to read value.", error.toException());
            }
        });


       // Log.w("Player_Controller", "controll return....");

        return null;
    }
}
