package com.bridgeit.ipl2017.view;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bridgeit.ipl2017.R;
import com.bridgeit.ipl2017.adapter.TeamAdapter;
import com.bridgeit.ipl2017.intrface.ArrayListTeam;
import com.bridgeit.ipl2017.model.TeamInfoModel;
import com.bridgeit.ipl2017.viewModel.TeamViewModel;

import java.util.ArrayList;
/*
* Auth : Sonawane Gokul R.
* Date : 30/1/2017
* Disc : it contain  Recycler View of Team
*/
public class TeamFragment extends Fragment {

    private  ArrayList<TeamInfoModel> teamInfoModels=new ArrayList<>();
    ProgressDialog mDialog;
    private RecyclerView recyclerView;
    private OnFragmentInteractionListener mListener;

    public TeamFragment(ProgressDialog mDialog) {
            this.mDialog = mDialog;             //Main Activit Process Dialog
    }

    public TeamFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team, container, false);
        recyclerView  = (RecyclerView)view.findViewById(R.id.teamrecycler);
        showProgress();
        //Load All Team Data From Firbase json file
        TeamViewModel teamViewModel=new TeamViewModel(getActivity());
        teamViewModel.getTeamData(new ArrayListTeam()
        {
            @Override
            public void fireBaseData(ArrayList<TeamInfoModel> teamInfos)
            {
                teamInfoModels  = teamInfos;

                final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                // Atach cards to Recycler View with data
                TeamAdapter adapter = new TeamAdapter(teamInfoModels, getActivity());

                mDialog.dismiss();      //Dismiss Progress Dialog

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
                recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener()
                {
                    GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

                        @Override public boolean onSingleTapUp(MotionEvent e) {
                            return true;
                        }

                    });
                    @Override
                    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                        View child = rv.findChildViewUnder(e.getX(), e.getY());
                        if(child != null && gestureDetector.onTouchEvent(e)) {
                            int position = rv.getChildAdapterPosition(child);

                                showProgress(); //close Progress dialog

                            // After click on Team Card Replace the  Team Fragment to Player Fragment
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framemain,new PlayerFragment(teamInfoModels.get(position).getTeamname().toString(),mDialog)).addToBackStack(null).commit();
                                Toast.makeText(getActivity(),teamInfoModels.get(position).getTeamname()+"...",Toast.LENGTH_SHORT).show();
                        }

                        return false;
                    }

                    @Override
                    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                    }

                    @Override
                    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                    }
                });
                Log.d("Team_fragment", "get data returne  " );
            }

        });


      return view;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void showProgress() {
        //Process Dialog Creation
        mDialog  = new ProgressDialog(getActivity());
        mDialog.setMessage("Downloading Data please wait");
        mDialog.setCancelable(false);
        mDialog.show();
    }
}
