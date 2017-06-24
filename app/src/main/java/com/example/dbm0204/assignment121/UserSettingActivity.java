package com.example.dbm0204.assignment121;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by dbm0204 on 6/24/17.
 * used to inflate the settings page.
 * The class extends PrefenceActivity
 */

public class UserSettingActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.user_settings);
    }
}
