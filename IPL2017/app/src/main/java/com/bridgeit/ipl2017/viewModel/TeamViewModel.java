package com.bridgeit.ipl2017.viewModel;

import android.content.Context;
import android.util.Log;


import com.bridgeit.ipl2017.controller.TeamController;
import com.bridgeit.ipl2017.intrface.ArrayListTeam;
import com.bridgeit.ipl2017.model.TeamInfoModel;

import java.util.ArrayList;

/**
 *  Auth :Sonawane Gokul
 *  Date :22/1/2017
 *  Disc :TeamViewModel To inteface bitween View And Controller
 */

public class TeamViewModel {
        Context context;
    ArrayList<TeamInfoModel> list;
    public TeamViewModel(Context context)
    {
        this.context=context;
    }
    public void getTeamData(final ArrayListTeam arrayListdata){ //var :arrayListdata - Intefaxe object to return data in teamModel

        //call for Controller to connect with Firbase to fetch data
        TeamController teamController=new TeamController();
        Log.d("Team_View_Model", "get data " );


        teamController.getTeamInfoModels(new ArrayListTeam()  //Cpontroller Methode Call
        {
            @Override
            public void fireBaseData(ArrayList<TeamInfoModel> teamInfoModels)
            {
                list  = teamInfoModels;

                arrayListdata.fireBaseData(list);
                Log.d("Team_View_Model", "get data returne " );
            }

        });
        Log.d("Team_View_Model", "get data returne " );


    }


}
