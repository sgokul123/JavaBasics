package com.bridgeit.ipl2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bridgeit.ipl2017.utility.Debug;
import com.bridgeit.ipl2017.view.LoginFragment;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Debug.showLog(TAG,"MAinActivity Started");
        // calling to Login Fragment

        getSupportFragmentManager().beginTransaction().replace(R.id.framemain, LoginFragment.newInstance(),LoginFragment.TAG).commit();

    }


}