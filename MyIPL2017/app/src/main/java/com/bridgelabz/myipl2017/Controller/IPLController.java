package com.bridgelabz.myipl2017.Controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bridgelabz.myipl2017.Model.PlayerInfoModel;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by bridgeit on 18/1/17.
 */

public class IPLController {
        Context context;
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;
    PlayerInfoModel playerInfoModel;
    private List<PlayerInfoModel>  value;
        public   IPLController(Context context){
            this.context=context;
        }

    public List<PlayerInfoModel> getPlayerdata()
    {
        Log.d("Controller", "Value done.. " );
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference().child("GujaratLions").child("0");

        // Post p=new Post("gokul","gokulsonawaekkkn");
        Log.d("kl", "Value is: 1" );

        //myRef.child("data").setValue(p);
        Query myTopPostsQuery = myRef.child("GujaratLions").child("1");
        myTopPostsQuery.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
            // TODO: implement the ChildEventListener methods as documented above
            // ...
        });
        myRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
              playerInfoModel= dataSnapshot.getValue(PlayerInfoModel.class);//return Player Data
                  Log.d("kl", "Value is: " + playerInfoModel.getPlayer_name());
                Toast.makeText(context.getApplicationContext(),"Data is returned",Toast.LENGTH_SHORT).show();
            }
             @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("hjghj", "Failed to read value.", error.toException());
            }
        });
        Log.d("Controller", "Value done..return " );

        return value;
    }
}
