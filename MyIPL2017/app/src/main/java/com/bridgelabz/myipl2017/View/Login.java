package com.bridgelabz.myipl2017.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bridgelabz.myipl2017.R;
import com.bridgelabz.myipl2017.ViewModel.LoginViewModel;

public class Login extends AppCompatActivity {
    String UName,Pass;
    EditText editTextName;
    EditText editTextPwd;
    Button mLoginButton;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginButton=(Button)findViewById(R.id.buttonLogin);
        editTextName=(EditText) findViewById(R.id.UserName);
        editTextPwd=(EditText)findViewById(R.id.Password);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("log", "onClick: login class");
                UName=editTextName.getText().toString();
                Pass=editTextPwd.getText().toString();
                Log.i("log", "onClick: login class"+UName+Pass);
                viewModel = new LoginViewModel(Login.this);
                boolean flag =false;
                flag=viewModel.getLogin(UName,Pass);
                /*if(flag){
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }*/
            }
        });
    }
}
