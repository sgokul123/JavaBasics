package com.bridgelabz.ipl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bridgelabz.ipl.view.LoginFragment;

public class MainActivity extends AppCompatActivity {
    ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageMain);
        Toast.makeText(this, "main activity", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.framemain, new LoginFragment()).commit();
        imageView.setVisibility(View.INVISIBLE);
    }
}
