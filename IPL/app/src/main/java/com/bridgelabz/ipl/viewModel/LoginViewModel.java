package com.bridgelabz.ipl.viewModel;

import android.content.Context;
import android.util.Log;

import com.bridgelabz.ipl.controller.LoginController;
import com.bridgelabz.ipl.intrface.LoginInteface;
import com.bridgelabz.ipl.model.LoginModel;

/**
 * Created by bridgeit on 20/1/17.
 */

public class LoginViewModel {

    LoginController controller;
    Context context;


    public LoginViewModel(Context context) {
        this.context=context;
        controller = new LoginController(context);
    }


    //get Login to firebase data
    public void getLogin(String eMail, String pass, final  LoginInteface islogin) {

                                     //  Log.i("LoginView Model", "get signin...."+uName+pass);

        LoginModel loginModel=new LoginModel(eMail,pass);

        controller.getmDatabaseReference(loginModel ,new LoginInteface() {

            public void fireBaseLogin(Boolean login)
            {
                    islogin.fireBaseLogin(login);

                Log.i("LoginView Model", "get signin....return"+login);
            }
        });
    }

    //get Register with firebase data
    public  void registerUser(String eMail,String pass, final  LoginInteface isRegister){

        LoginModel loginModel=new LoginModel(eMail,pass);
        Log.i("LoginView Model", "get Registration....");
        controller.getUserRegister(loginModel ,new LoginInteface() {

            public void fireBaseLogin(Boolean register)
            {
                isRegister.fireBaseLogin(register);


            }
        });
    }
}