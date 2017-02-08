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
    String eMAil, pass;
    FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;
    static int flag = 0;

    public LoginController(Context context) {
        this.context = context;

    }

    public void getmDatabaseReference(LoginModel loginModel, final LoginInteface islogin)
    {
        mAuth = FirebaseAuth.getInstance();
        //mAuth.addAuthStateListener(mAuthListener);
        eMAil = loginModel.getEmail();
        pass = loginModel.getPass();

        Log.i("controller", "User ..." + eMAil + pass + "...");

        try {
            //Check Login Validation of E-mail And Password
            mAuth.signInWithEmailAndPassword(eMAil, pass).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
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
    public  void getUserRegister(LoginModel loginModel, final LoginInteface isRegistered){


        mAuth = FirebaseAuth.getInstance();

        eMAil = loginModel.getEmail();
        pass = loginModel.getPass();
                try {
                    Log.d("Registration Controller", "get register...."+eMAil+"  "+pass );

                    //Register New User to firebase Database.
                    mAuth.createUserWithEmailAndPassword(eMAil, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {

                                        isRegistered.fireBaseLogin(false);
                                        Log.d("Registration Controller", "createUserWithEmail:onComplete:");

                                    }
                                    else
                                    {
                                         Log.d("Registration Controller", "createUserWithEmail:onComplete:");
                                        isRegistered.fireBaseLogin(true);

                                    }
                                }
                            });
                }catch(Exception e){
                    Toast.makeText(context, "Something is Wrong ...", Toast.LENGTH_SHORT).show();
                }
    }

}