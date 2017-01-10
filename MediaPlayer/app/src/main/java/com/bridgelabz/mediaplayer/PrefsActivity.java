package com.bridgelabz.mediaplayer;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by bridgeit on 4/1/17.
 */
public class PrefsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}

