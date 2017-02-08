package com.bridgelabz.ipl.view;

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

import com.bridgelabz.ipl.R;
import com.bridgelabz.ipl.adapter.PlayerAdapter;
import com.bridgelabz.ipl.intrface.ArrayListPlayer;
import com.bridgelabz.ipl.model.PlayerInfoModel;
import com.bridgelabz.ipl.viewModel.PlayerViewModel;

import java.util.ArrayList;
/*
* Auth : Sonawane Gokul R.
* Date : 30/1/2017
* Disc : it contain  Recycler View of Player
*/
public class PlayerFragment extends Fragment {

    private ArrayList<PlayerInfoModel> playerInfoModels=new ArrayList<>();
    private  String teamName;
    ProgressDialog mDialog;
    private RecyclerView recyclerView;

    private TeamFragment.OnFragmentInteractionListener mListener;

    public PlayerFragment(ProgressDialog mDialog) {

        this.mDialog = mDialog;

    }

    public PlayerFragment(String teamName,ProgressDialog mDialog) {
            this.teamName=teamName;
            this.mDialog=mDialog;
    }


    public static TeamFragment newInstance(String param1, String param2) {
        TeamFragment fragment = new TeamFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player, container, false);
        recyclerView  = (RecyclerView)view.findViewById(R.id.playerrecycler);
        //Download Player data Form Firebase.
        PlayerViewModel playerViewModel=new PlayerViewModel(getActivity());

        playerViewModel.getPlayerData(teamName,new ArrayListPlayer()
        {
            @Override
            public void fireBaseData(ArrayList<PlayerInfoModel> playerInfo)
            {
                playerInfoModels  = playerInfo;
                final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                //load data with RecyclerView
                PlayerAdapter adapter = new PlayerAdapter(playerInfoModels, getActivity(),mDialog);

                  // mDialog.dismiss();
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

                //assign  Listener to RecyclerView
                recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
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
                          //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framemain,new PlayerFragment()).commit();
                            Toast.makeText(getActivity(),playerInfoModels.get(position).getPlayer_name()+"...",Toast.LENGTH_SHORT).show();
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
                Log.d("Player_fragment", "get data returne 1 " );
            }

        });


        return view;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
