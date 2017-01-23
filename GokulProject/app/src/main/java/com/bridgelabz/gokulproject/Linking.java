package com.bridgelabz.gokulproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Linking extends AppCompatActivity {
    EditText editText1;
    WebView webView1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linking);
       //editText1=(EditText)findViewById(R.id.editText);
      //  button1=(Button)findViewById(R.id.button4);
        webView1=(WebView)findViewById(R.id.webBiew1);
        webView1.loadUrl("http://www.javatpoint.com/android-webview-example");

       /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   String s1=editText1.getText().toString();
               // Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(s1));
                //startActivity(intent);
            }
        });*/
    }
}
