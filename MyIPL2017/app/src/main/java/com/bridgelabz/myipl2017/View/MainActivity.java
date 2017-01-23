package com.bridgelabz.myipl2017.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bridgelabz.myipl2017.Model.PlayerInfoModel;
import com.bridgelabz.myipl2017.R;
import com.bridgelabz.myipl2017.ViewModel.InfoViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PlayerInfoModel> playerList = new ArrayList<>();
    RecyclerView recyclerView;
    private PlayerAdapterView mAdapter;
    private InfoViewModel infoViewModel;
    // private List<Movie> playerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new PlayerAdapterView(this, playerList); // call adapter class
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        infoViewModel=new InfoViewModel(this);

/*
        PlayerInfoModel movie = new PlayerInfoModel("","left_handed", "Off-spin ","1 October 1994","","gokul sonawne","Indian","Batsman");
        playerList.add(movie);

        movie = new PlayerInfoModel("","left_handed", "Off-spin and medium pace ","7 October 1997","","sachin sonawne","Indian","Batsman");
        playerList.add(movie);

        movie = new PlayerInfoModel("","Right_handed", "medium pace ","5 October 1992","","ramesh sonawne","Indian","Batsman");
        playerList.add(movie);

        movie = new PlayerInfoModel("","left_handed", "Off-spin and medium pace ","6 October 1994","","shankar sonawne","Indian","Batsman");
        playerList.add(movie);
        movie = new PlayerInfoModel("","left_handed", "Off-spin and medium pace ","10 October 1995","","sager sonawne","Indian","Batsman");
        playerList.add(movie);
*/

        RecyclerView.Adapter adapter =  infoViewModel.getPlayerView(getCurrentFocus());
        recyclerView.setAdapter(adapter);


    }
    private void prepareMovieData() {

       // mAdapter.notifyDataSetChanged();

    }
}
