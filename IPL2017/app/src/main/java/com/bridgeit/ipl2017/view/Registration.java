package com.bridgeit.ipl2017.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.bridgeit.ipl2017.R;
import com.bridgeit.ipl2017.intrface.LoginInteface;
import com.bridgeit.ipl2017.utility.Debug;
import com.bridgeit.ipl2017.viewModel.LoginViewModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
* Auth : Sonawane Gokul R.
* Date : 20/1/2017
* Disc : it contains  E-Mail And Password Registration for new User.
*/

public class Registration extends Fragment {
    public static final String TAG = "Registiation";
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Context context;
    private  EditText mEmailid, mPassword1, mPassword2;
    private Button mButtonRegister, mButtonCancel;
    private  String mE_Mail, mPass1, mPass2;
    private Pattern mPattern;
    private Matcher mMatcher;
    private ProgressDialog mDialog;
    public Registration(Context context) {
        this.context=context;
        // Required empty public constructor
    }

    public Registration() {

    }

    public static Registration newInstance(String param1, String param2) {
        Registration fragment = new Registration();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        mButtonCancel =(Button)view.findViewById(R.id.button_registration_cancel);
        mButtonRegister =(Button)view.findViewById(R.id.button_register);
        mEmailid =(EditText)view.findViewById(R.id.editview_registration_email);
        mPassword1 =(EditText)view.findViewById(R.id.edittext_registration_pass1);
        mPassword2 =(EditText)view.findViewById(R.id.edittext_registration_pass2);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPattern = Pattern.compile(EMAIL_PATTERN);
                mE_Mail = mEmailid.getText().toString();

                // Read E-Mail And Password
                mPass1 = mPassword1.getText().toString();
                mPass2 = mPassword2.getText().toString();

                // Check Whether it contains Null Value if yess then display Message
                if(!(mE_Mail.equals("")|| mPass1.equals("")|| mPass2.equals(""))) {

                    mMatcher = mPattern.matcher(mE_Mail);

                    // check is E_Mail Valid Or Not
                    if (mMatcher.matches()) {

                        // Check whether Both Password Enterd Are Equals or not
                        if (mPass1.equalsIgnoreCase(mPass2) && mPass1.length()>5)
                        {
                            //Start ProgressDialog While User Registration .
                            showProgress();
                            LoginViewModel viewModel = new LoginViewModel(context);
                            Debug.showLog(TAG,"get data..");

                            viewModel.registerUser(mE_Mail, mPass1, new LoginInteface() {
                                @Override
                                public void fireBaseLogin(Boolean isRegister) {
                                    if (isRegister) {

                                        mDialog.dismiss();

                                        Debug.showLog(TAG,"get data return ...");
                                        Toast.makeText(getActivity().getApplicationContext(), "User is Registered  ", Toast.LENGTH_SHORT).show();
                                        // close Progress dialog after Registration and return to Login Page.
                                        getActivity().getSupportFragmentManager().beginTransaction().remove(Registration.this).commit();
                                        getActivity(). getSupportFragmentManager().beginTransaction().replace(R.id.framemain, LoginFragment.newInstance(),LoginFragment.TAG).commit();
                                    } else {
                                        // if User Will not Register Then Display Message .
                                        mDialog.dismiss();
                                        Toast.makeText(getActivity().getApplicationContext(), "User is not Registered...", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                        }
                        else{

                            Toast.makeText(getActivity().getApplicationContext(),"Password must be at least 6 characters...", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Please Enter Valid Email ...", Toast.LENGTH_SHORT).show();

                    }
                }

                // Make all Field Blank
                mEmailid.setText("");
                mPassword1.setText("");
                mPassword2.setText("");
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  On Cancel Button click it will return to Login Page

                getActivity().getSupportFragmentManager().beginTransaction().remove(Registration.this).commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framemain, LoginFragment.newInstance(),LoginFragment.TAG).commit();
            }
        });
        return view;
    }

    public void showProgress() {
        mDialog  = new ProgressDialog(getActivity());
        mDialog.setMessage("Registering New User...");
        mDialog.setCancelable(false);
        mDialog.show();
    }

}
