package com.bridgeit.ipl2017.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.bridgeit.ipl2017.R;
import com.bridgeit.ipl2017.intrface.LoginInteface;
import com.bridgeit.ipl2017.viewModel.LoginViewModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
* Auth : Sonawane Gokul R.
* Date : 20/1/2017
* Disc : it contains  E-Mail And Password Registration for new User.
*/

public class Registration extends Fragment {
    private  EditText emailid,password1,password2;
    private Button buttonRegister,buttonCancel;
    private  String eMail,stringPass1,stringPass2;
    private Pattern pattern;
    Context context;
    private Matcher matcher;
    private ProgressDialog mDialog;
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
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
        buttonCancel=(Button)view.findViewById(R.id.buttonCancel);
        buttonRegister=(Button)view.findViewById(R.id.buttonRegister);
        emailid=(EditText)view.findViewById(R.id.editTexEmail);
        password1=(EditText)view.findViewById(R.id.editTextPass1);
        password2=(EditText)view.findViewById(R.id.editTextPass2);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pattern = Pattern.compile(EMAIL_PATTERN);
                eMail=emailid.getText().toString();

                // Read E-Mail And Password
                stringPass1=password1.getText().toString();
                stringPass2=password2.getText().toString();

                // Check Whether it contains Null Value if yess then display Message
                if(!(eMail.equals("")||stringPass1.equals("")||stringPass2.equals(""))) {

                    matcher = pattern.matcher(eMail);

                    // check is E_Mail Valid Or Not
                    if (matcher.matches()) {

                        // Check whether Both Password Enterd Are Equals or not
                        if (stringPass1.equalsIgnoreCase(stringPass2) && stringPass1.length()>5)
                        {
                            //Start ProgressDialog While User Registration .
                            showProgress();

                            LoginViewModel viewModel = new LoginViewModel(context);


                            Log.d("Registration_fragment", "get data... " );
                             viewModel.registerUser(eMail, stringPass1, new LoginInteface() {
                                 @Override
                                 public void fireBaseLogin(Boolean isRegister) {
                                     if (isRegister) {
                                          mDialog.dismiss();
                                          Log.d("Registration_fragment", "get data...return " );

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
                emailid.setText("");
                password1.setText("");
                password2.setText("");
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
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
