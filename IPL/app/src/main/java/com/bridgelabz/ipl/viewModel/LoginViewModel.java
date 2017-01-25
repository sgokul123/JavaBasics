package com.bridgelabz.ipl.viewModel;

import android.content.Context;
import android.util.Log;

import com.bridgelabz.ipl.controller.LoginController;
import com.bridgelabz.ipl.model.LoginModel;

/**
 * Created by bridgeit on 20/1/17.
 */
public class LoginViewModel {
    LoginController controller;
    Context context;

    public LoginViewModel(Context context) {
        this.context=context;
    }

    public boolean getLogin(String uName, String pass) {
        Log.i("LoginView Model", "Sign in Problem...."+uName+pass);

        controller = new LoginController(context);
      //  Log.i("model", "getLogin: viewmodel class");
        LoginModel loginModel=new LoginModel(uName,pass);
        Log.i("model ", "getLogin: viewmodel class");
        boolean flag=false;
        flag=controller.getmDatabaseReference(loginModel );


        return flag;


    }
}