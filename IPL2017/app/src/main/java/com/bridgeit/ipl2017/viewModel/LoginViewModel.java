package com.bridgeit.ipl2017.viewModel;

import android.content.Context;

import com.bridgeit.ipl2017.controller.LoginController;
import com.bridgeit.ipl2017.intrface.LoginInteface;
import com.bridgeit.ipl2017.model.LoginModel;
import com.bridgeit.ipl2017.utility.Debug;


/**
 * Created by bridgeit on 20/1/17.
 */

public class LoginViewModel {
    public static final String TAG = "LoginViewModel";
    LoginController controller;
    Context context;


    public LoginViewModel(Context context) {
        this.context=context;
        controller = new LoginController(context);
    }


    //get Login to firebase data
    public void getLogin(String eMail, String pass, final LoginInteface islogin) {

        //  Log.i("LoginView Model", "get signin...."+uName+pass);

        LoginModel loginModel=new LoginModel(eMail,pass);

        controller.getmDatabaseReference(loginModel ,new LoginInteface() {

            public void fireBaseLogin(Boolean login)
            {
                islogin.fireBaseLogin(login);
                Debug.showLog(TAG,"get sign In...");
            }
        });
    }

    //get Register with firebase data
    public  void registerUser(String eMail,String pass, final  LoginInteface isRegister){

        LoginModel loginModel=new LoginModel(eMail,pass);
        Debug.showLog(TAG,"Get Registration ...");
        controller.getUserRegister(loginModel ,new LoginInteface() {

            public void fireBaseLogin(Boolean register)
            {
                isRegister.fireBaseLogin(register);


            }
        });
    }
}