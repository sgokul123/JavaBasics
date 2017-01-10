package com.bridgelabz.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XMLPullParser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlpull_parser);

        ListView listView = (ListView) findViewById(R.id.listView1);

        List<Employee> employees = null;
        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            InputStream is=getAssets().open("employees.xml");
            employees=parser.parse(is);

            ArrayAdapter<Employee> adapter =new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1, employees);
            listView.setAdapter(adapter);

        } catch (IOException e) {e.printStackTrace();}

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
