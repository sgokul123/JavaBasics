package com.bridgelabz.ipl.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.bridgelabz.ipl.intrface.LoginInteface;
import com.bridgelabz.ipl.model.LoginModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by bridgeit on 20/1/17.
 */

public class LoginController  {
    Context context;
    String name, pass;
    FirebaseAuth mAuth;
    static int flag = 0;

    public LoginController(Context context) {
        this.context = context;

    }

    public void getmDatabaseReference(LoginModel loginModel, final LoginInteface islogin)
    {
        mAuth = FirebaseAuth.getInstance();

        name = loginModel.getEmail();
        pass = loginModel.getPass();

        Log.i("controller", "User ..." + name + pass + "...");

        try {
            mAuth.signInWithEmailAndPassword(name, pass).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (!task.isSuccessful())
                            {
                                Log.i("controller", "Sign in Problem..hkh..");
                                islogin.fireBaseLogin(false);
                            }
                            else
                            {
                                Log.i("controller", "Login Successful");
                                islogin.fireBaseLogin(true);

                            }

                        }
                    });

        } catch (Exception e) {
            Log.i("controller", "somethis is wrong ....");
            Toast.makeText(context, "Something is Wrong ...", Toast.LENGTH_SHORT).show();
        }


    }


}