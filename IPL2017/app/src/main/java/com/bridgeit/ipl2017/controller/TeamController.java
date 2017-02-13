package com.bridgeit.ipl2017.controller;

import com.bridgeit.ipl2017.intrface.ArrayListTeam;
import com.bridgeit.ipl2017.model.TeamInfoModel;
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
 * Disc :this will Load Team data From FireBase claude
 */

public class TeamController {
    public static final String TAG = "TeamController";

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    ArrayList<TeamInfoModel> mTeamInfoModels;

    public TeamController() {
        mTeamInfoModels =new ArrayList<>();
    }

    public DatabaseReference  getTeamInfoModels(final ArrayListTeam arrayListdata){

        //Load Instance of Firebase and get Reference
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("ipl");

            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<ArrayList<TeamInfoModel>> t = new GenericTypeIndicator<ArrayList<TeamInfoModel>>() {
                    };
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    Debug.showLog(TAG,"Geting Data..");
                    ArrayList<TeamInfoModel> modelArrayList = new ArrayList<TeamInfoModel>();
                    //get data And assign to ArrayList
                    modelArrayList.addAll(dataSnapshot.getValue(t));
                    // return ArrayList to TeamViewModel by using Interface
                    arrayListdata.fireBaseData(modelArrayList);

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Debug.showLog(TAG,"Failed To Read Data..");

                }
            });

        return null;
    }


}
