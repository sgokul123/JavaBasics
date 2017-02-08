package com.bridgelabz.ipl.controller;

import android.util.Log;

import com.bridgelabz.ipl.intrface.ArrayListTeam;
import com.bridgelabz.ipl.model.TeamInfoModel;
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
    FirebaseDatabase database ;
    DatabaseReference myRef ;
    ArrayList<TeamInfoModel> teamInfoModels;

    public TeamController() {
        teamInfoModels=new ArrayList<>();
    }

    public DatabaseReference  getTeamInfoModels(final ArrayListTeam arrayListdata){

        //Load Instance of Firebase and get Reference
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("ipl");

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<ArrayList<TeamInfoModel>> t = new GenericTypeIndicator<ArrayList<TeamInfoModel>>() {
                    };  // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    Log.d("Team_controller", "Value is: " );
                    ArrayList<TeamInfoModel> modelArrayList = new ArrayList<TeamInfoModel>();

                    //get data And assign to ArrayList
                    modelArrayList.addAll(dataSnapshot.getValue(t));

                    // return ArrayList to TeamViewModel by using Interface
                    arrayListdata.fireBaseData(modelArrayList);
                    /*int i=0;

                    while(i<8)
                    {
                        TeamInfoModel value = modelArrayList.get(i);
                      //  teamInfoModels.add(value);
                        Log.d("kl", "Value is: " + value.getUrl() + "  "+value.getOwner()+value.getTeamname());
                        //textView.setText(textView.getText() + value.getUrl() +"  "+ value.getOwner()+"  "+value.getTeamname() + "\n");
                        i=i+1;
                    }
*/

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("Team_Controller", "Failed to read value.", error.toException());
                }
            });


        Log.w("Team_Controller", "controll return....");

        return null;
    }


}
