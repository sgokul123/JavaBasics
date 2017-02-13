package com.bridgeit.ipl2017.viewModel;

import android.content.Context;
import android.util.Log;

import com.bridgeit.ipl2017.controller.PlayerController;
import com.bridgeit.ipl2017.intrface.ArrayListPlayer;
import com.bridgeit.ipl2017.model.PlayerInfoModel;

import java.util.ArrayList;


/**
 * Created by bridgeit on 27/1/17.
 */

public class PlayerViewModel {
    Context context;
    ArrayList<PlayerInfoModel> list;
    String t_Name;
    public PlayerViewModel(Context context)
    {
        this.context=context;
    }
    public void getPlayerData(String teamName,final ArrayListPlayer arraylistplayer){

        t_Name=teamName;
        PlayerController playerController=new PlayerController();
        Log.d("Player_View_Model", "get data "+t_Name);


        playerController.getPlayerInfoModels(t_Name,new ArrayListPlayer()
        {
            @Override
            public void fireBaseData(ArrayList<PlayerInfoModel> playerInfoModels)
            {
                list  = playerInfoModels;
                arraylistplayer.fireBaseData(list);
                Log.d("Player_View_Model", "get data returne " );
            }

        });
       // Log.d("Player_View_Model", "get data returne " );


    }
}
