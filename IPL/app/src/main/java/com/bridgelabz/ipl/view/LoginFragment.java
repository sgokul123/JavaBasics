package com.bridgelabz.ipl.view;

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

import com.bridgelabz.ipl.R;
import com.bridgelabz.ipl.intrface.LoginInteface;
import com.bridgelabz.ipl.viewModel.LoginViewModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* Auth : Sonawane Gokul R.
* Date : 30/1/2017
* Disc : it contains ogin Fragment , there is only User Name And Password
*/
public class LoginFragment extends Fragment
{
    private boolean flag=false;
    private   String strEmail,strPass;
    private Context context;
    private ProgressDialog mDialog;
    private  EditText editTextName;
    private EditText editTextPass;
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public LoginFragment(Context context) {
        this.context =context;
    }

    public LoginFragment() {

    }


    public static Fragment newInstance(String url) {

        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString("URL", url);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v= inflater.inflate(R.layout.fragment_login, container, false);

        editTextName= (EditText) v.findViewById(R.id.editName);
        editTextPass= (EditText) v.findViewById(R.id.editPass);
        Log.i("namne", "onCreateView: "+ strEmail +"..."+strPass);
        Log.i("namne", "onCreateView: "+ strEmail +"..."+strPass);
        Button buttonLogin = (Button)v.findViewById(R.id.buttonLogin);

        pattern = Pattern.compile(EMAIL_PATTERN);   // Pattern Matcher For Email Validation

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strEmail = editTextName.getText().toString();
                strPass = editTextPass.getText().toString();

                if(!(strEmail.equals("")&&strPass.equals(""))) {
                    matcher = pattern.matcher(strEmail);
                    if (matcher.matches())
                    {
                        showProgress();
                        LoginViewModel viewModel = new LoginViewModel(context);
                        viewModel.getLogin(strEmail, strPass, new LoginInteface() {

                        @Override
                        public void fireBaseLogin(Boolean isLogin) {

                            if (isLogin) {
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framemain, new TeamFragment(mDialog)).addToBackStack(null).commit();
                                Toast.makeText(getActivity().getApplicationContext(), "Login Success  ", Toast.LENGTH_SHORT).show();

                            } else {
                                mDialog.dismiss();
                                Toast.makeText(getActivity().getApplicationContext(), "Do Not Match User Name And Password ...", Toast.LENGTH_SHORT).show();
                            }
                        }
                        });
                        editTextName.setText("");
                        editTextPass.setText("");
                    }
                    else
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Please Enter Valid Email ...", Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),"Please Enter The User Name  And Password ... ",Toast.LENGTH_SHORT).show();
                }
            }
        });

       return v;
    }
    public void showProgress() {
        mDialog  = new ProgressDialog(getActivity());
        mDialog.setMessage("Downloading Data please wait");
        mDialog.setCancelable(false);
        mDialog.show();
    }

}
