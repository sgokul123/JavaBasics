package com.bridgelabz.happynewyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class WebSearch extends AppCompatActivity {
    WebView webView1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_search);
        webView1=(WebView)findViewById(R.id.webView1);
        button1=(Button)findViewById(R.id.button6);
        webView1.loadUrl("http://first-wishes.com/new/?n=Sonawane-Gokul");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
