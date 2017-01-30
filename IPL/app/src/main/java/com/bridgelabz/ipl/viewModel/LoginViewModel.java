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
    }

    public void getLogin(String uName, String pass, final  LoginInteface islogin) {
        Log.i("LoginView Model", "get signin...."+uName+pass);

        controller = new LoginController(context);
        LoginModel loginModel=new LoginModel(uName,pass);
        controller.getmDatabaseReference(loginModel ,new LoginInteface() {
            public void fireBaseLogin(Boolean login)
            {
                    islogin.fireBaseLogin(login);
                Log.i("LoginView Model", "get signin....return"+login);

            }
        });
    }
}