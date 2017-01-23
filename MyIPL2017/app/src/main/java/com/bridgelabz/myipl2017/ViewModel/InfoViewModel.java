package com.bridgelabz.myipl2017.ViewModel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bridgelabz.myipl2017.Controller.IPLController;
import com.bridgelabz.myipl2017.Model.PlayerInfoModel;
import com.bridgelabz.myipl2017.View.PlayerAdapterView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by bridgeit on 18/1/17.
 */

public class InfoViewModel {
    private List<PlayerInfoModel> Playerdata;
    private  Context context;
    private PlayerAdapterView playerAdapterView;
    private IPLController iplController;
    RecyclerView recyclerView;
    public  InfoViewModel(Context context)
    {
        iplController=new IPLController(context);
    }

    public RecyclerView.Adapter getPlayerView(View view){
        Log.d(" Info View Model", "Value done.. " );
       Playerdata.addAll(iplController.getPlayerdata());
        playerAdapterView =new PlayerAdapterView(context,Playerdata);
        RecyclerView.Adapter adapter=playerAdapterView;
        Log.d(" Info View Model", "Value done..return " );
        return adapter;
    }
}
