package com.bridgelabz.myipl2017.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.bridgelabz.myipl2017.Controller.LoginController;
import com.bridgelabz.myipl2017.Model.LoginModel;
import com.bridgelabz.myipl2017.View.MainActivity;

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
        Log.i("LoginView Model", "Sign in Problem....");

        controller = new LoginController(context);
        Log.i("model", "getLogin: viewmodel class");
        LoginModel loginModel=new LoginModel(uName,pass);

        boolean flag=false;
        flag=controller.getmDatabaseReference(loginModel );
        Log.i("model", "getLogin: viewmodel class"+flag);

        return flag;


    }
}