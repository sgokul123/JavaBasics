package com.bridgeit.ipl2017.viewModel;

import android.content.Context;
import android.util.Log;

import com.bridgeit.ipl2017.controller.TeamController;
import com.bridgeit.ipl2017.intrface.ArrayListTeam;
import com.bridgeit.ipl2017.model.TeamInfoModel;
import com.bridgeit.ipl2017.utility.Debug;

import java.util.ArrayList;

/**
 *  Auth :Sonawane Gokul
 *  Date :22/1/2017
 *  Disc :TeamViewModel To inteface bitween View And Controller
 */

public class TeamViewModel {

    public static final String TAG = "TeamViewModel";
    private Context context;
    private ArrayList<TeamInfoModel> list;
    public TeamViewModel(Context context)
    {
        this.context=context;
    }
    public void getTeamData(final ArrayListTeam arrayListdata)           //var :arrayListdata - Intefaxe object to return data in teamModel
    {


        //call for Controller to connect with Firbase to fetch data
        TeamController teamController=new TeamController();
        Debug.showLog(TAG,"get data...");

        teamController.getTeamInfoModels(new ArrayListTeam()  //Cpontroller Methode Call
        {
            @Override
            public void fireBaseData(ArrayList<TeamInfoModel> teamInfoModels)
            {
                list  = teamInfoModels;
                arrayListdata.fireBaseData(list);
                Debug.showLog(TAG,"get sata return...");

            }

        });
    }


}
