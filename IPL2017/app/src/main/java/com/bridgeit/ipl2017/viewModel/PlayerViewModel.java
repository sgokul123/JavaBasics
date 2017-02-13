package com.bridgeit.ipl2017.viewModel;

import android.content.Context;

import com.bridgeit.ipl2017.controller.PlayerController;
import com.bridgeit.ipl2017.intrface.ArrayListPlayer;
import com.bridgeit.ipl2017.model.PlayerInfoModel;
import com.bridgeit.ipl2017.utility.Debug;

import java.util.ArrayList;


/**
 * Created by bridgeit on 27/1/17.
 */

public class PlayerViewModel {

    public static final String TAG = "PlayerViewModel";

    private Context context;
    private ArrayList<PlayerInfoModel> list;
    private String t_Name;

    public PlayerViewModel(Context context)
    {
        this.context=context;
    }
    public void getPlayerData(String teamName,final ArrayListPlayer arraylistplayer){

        t_Name=teamName;
        PlayerController playerController=new PlayerController();
        Debug.showLog(TAG,"get data...");

        playerController.getPlayerInfoModels(t_Name,new ArrayListPlayer()
        {
            @Override
            public void fireBaseData(ArrayList<PlayerInfoModel> playerInfoModels)
            {
                list  = playerInfoModels;
                arraylistplayer.fireBaseData(list);
                Debug.showLog(TAG,"get data return...");

            }

        });
        // Log.d("Player_View_Model", "get data returne " );

    }
}
