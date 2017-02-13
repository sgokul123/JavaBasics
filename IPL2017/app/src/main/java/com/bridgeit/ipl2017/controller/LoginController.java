package com.bridgeit.ipl2017.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.bridgeit.ipl2017.intrface.LoginInteface;
import com.bridgeit.ipl2017.model.LoginModel;
import com.bridgeit.ipl2017.utility.Debug;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by bridgeit on 20/1/17.
 */

public class LoginController  {
    public static final String TAG = "LoginController";

    Context mContext;
    String mStrMail, mStrPass;
    FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;
    static int flag = 0;

    public LoginController(Context context) {
        this.mContext = context;

    }

    public void getmDatabaseReference(LoginModel loginModel, final LoginInteface islogin)
    {
        mAuth = FirebaseAuth.getInstance();
        //mAuth.addAuthStateListener(mAuthListener);
        mStrMail = loginModel.getEmail();
        mStrPass = loginModel.getPass();
        Debug.showLog(TAG,"User ..." + mStrMail + mStrPass + "...");


        try {
            //Check Login Validation of E-mail And Password
            mAuth.signInWithEmailAndPassword(mStrMail, mStrPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (!task.isSuccessful())
                            {
                                Debug.showLog(TAG,"Sign in Problem...");

                                islogin.fireBaseLogin(false);
                            }
                            else
                            {
                                Debug.showLog(TAG,"Login Successful");

                                islogin.fireBaseLogin(true);

                            }

                        }
                    });

        } catch (Exception e) {
            Debug.showLog(TAG,"Something is wrong...");

            Toast.makeText(mContext, "Something is Wrong ...", Toast.LENGTH_SHORT).show();
        }


    }
    public  void getUserRegister(LoginModel loginModel, final LoginInteface isRegistered){


        mAuth = FirebaseAuth.getInstance();

        mStrMail = loginModel.getEmail();
        mStrPass = loginModel.getPass();
                try {

                    Debug.showLog(TAG,"Get Register..."+ mStrMail +" "+ mStrPass);
                    //Register New User to firebase Database.
                    mAuth.createUserWithEmailAndPassword(mStrMail, mStrPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {

                                        isRegistered.fireBaseLogin(false);
                                       Debug.showLog(TAG,"On not Complete..");
                                    }
                                    else
                                    {
                                        Debug.showLog(TAG,"On Complete..");
                                       isRegistered.fireBaseLogin(true);

                                    }
                                }
                            });
                }catch(Exception e){
                    Toast.makeText(mContext, "Something is Wrong ...", Toast.LENGTH_SHORT).show();
                }
    }

}