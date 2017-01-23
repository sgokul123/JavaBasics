package com.bridgelabz.myipl2017.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.bridgelabz.myipl2017.Model.LoginModel;
import com.bridgelabz.myipl2017.View.Login;
import com.bridgelabz.myipl2017.View.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by bridgeit on 20/1/17.
 */

public class LoginController {
    Context context;
    String name,pass;
    FirebaseAuth  mAuth;
    int flag=0;

    public LoginController(Context context) {
        this.context=context;
    }

    public boolean getmDatabaseReference(LoginModel loginModel ) {
        mAuth = FirebaseAuth.getInstance();

        name=loginModel.getEmail();
        pass=loginModel.getPass();
        if(name.isEmpty()|| pass.isEmpty()){
            Log.i("controller", "User name and pass is Empty...");
            flag=0;
        }
        mAuth.signInWithEmailAndPassword(name,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Log.i("controller", "Sign in Problem....");
                    Toast.makeText(context,"Login Problem...",Toast.LENGTH_SHORT).show();
                    flag=0;
                }
                else{
                    flag=1;
                    Log.i("controller", "Login Successful");
                    Toast.makeText(context,"Login Successfull..."+flag,Toast.LENGTH_SHORT).show();
                    /*Intent intent=new Intent(context.getApplicationContext(),MainActivity.class);
                    context.startActivity(intent);*/

                }
            }
        });
       if(flag==1){
           return true;
       }
        else
       {
           return false;
       }
    }
}
