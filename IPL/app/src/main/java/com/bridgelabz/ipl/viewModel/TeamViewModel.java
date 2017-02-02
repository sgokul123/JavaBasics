package com.bridgelabz.ipl.viewModel;

import android.content.Context;
import android.util.Log;

import com.bridgelabz.ipl.intrface.ArrayListTeam;
import com.bridgelabz.ipl.controller.TeamController;
import com.bridgelabz.ipl.model.TeamInfoModel;

import java.util.ArrayList;

/**
 * Created by bridgeit on 27/1/17.
 */

public class TeamViewModel {
        Context context;
    ArrayList<TeamInfoModel> list;
    public TeamViewModel(Context context)
    {
        this.context=context;
    }
    public void getTeamData(final ArrayListTeam arrayListdata){


        TeamController teamController=new TeamController();
        Log.d("Team_View_Model", "get data " );


        teamController.getTeamInfoModels(new ArrayListTeam()
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
