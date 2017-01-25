package com.bridgelabz.ipl.view;

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
import com.bridgelabz.ipl.viewModel.LoginViewModel;

public class LoginFragment extends Fragment
{

        private   String strName="gokul";
    String strPass= "gokul";
        Context context;
    EditText editTextName;
    EditText editTextPass;
    public LoginFragment() {

    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

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
        Toast.makeText(getActivity(), "frafgment", Toast.LENGTH_SHORT).show();
        editTextName= (EditText) v.findViewById(R.id.editName);
         editTextPass= (EditText) v.findViewById(R.id.editPass);
        //Button buttonLogin=(Button) v.findViewById(R.id.buttonLogin);
      //  buttonLogin.setOnClickListener(this);
        Log.i("namne", "onCreateView: "+strName+"..."+strPass);
      //  strName = editTextName.getText().toString();
        //strPass = editTextPass.getText().toString();
     // Toast.makeText(context.getApplicationContext(),"Success  "+strName+"..."+strPass,Toast.LENGTH_SHORT).show();
        Log.i("namne", "onCreateView: "+strName+"..."+strPass);
        Button buttonLogin = (Button)v.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strName = editTextName.getText().toString();
                strPass = editTextPass.getText().toString();
                //Toast.makeText(getActivity(),"Success  "+strName+"..."+strPass,Toast.LENGTH_SHORT).show();
                if(!(strName.equals("")&&strPass.equals(""))){
                    LoginViewModel viewModel = new LoginViewModel(getActivity());
                       viewModel.getLogin(strName,strPass);
                    Toast.makeText(getActivity().getApplicationContext(),"Success  1"+strName+strPass+"...",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),"Please vEnter The User NAme  & Password... ",Toast.LENGTH_SHORT).show();
                }
            }
        });

       return v;
    }



}
