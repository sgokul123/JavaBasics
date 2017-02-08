package com.bridgelabz.ipl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bridgelabz.ipl.view.LoginFragment;

/*
*Auth  : Gokul Sonawane
* Date :16/1/2017
* Disc : IPL App with Registration and Login  ,It lists all Team's and Player of all team.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "main activity", Toast.LENGTH_SHORT).show();

        // calling to Login Fragment

        getSupportFragmentManager().beginTransaction().replace(R.id.framemain, new LoginFragment(this)).commit();

    }


}
