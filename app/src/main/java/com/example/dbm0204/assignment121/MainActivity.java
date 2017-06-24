package com.example.dbm0204.assignment121;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SETTINGS_RESULT=1;
    Button SettingButton;

    @Override
    //Inflates the main page and transfers the main thread to the settings Page  on Click of the Settings Button
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Button bynSettings=(Button) findViewById(R.id.buttonSettings);
        bynSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),UserSettingActivity.class);
                startActivityForResult(i,SETTINGS_RESULT);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==SETTINGS_RESULT){
            displayUserSettings();

        }
    }
    //This method is used to diaply the UserSeetings Page/
    private void displayUserSettings(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String settings="";
        settings=settings+"Password"+sharedPreferences.getString("prefUserPassword","NOPASSWORD");
        settings=settings+"\nRemind For Update"+sharedPreferences.getBoolean("prefLockScreen",false);
        settings=settings+"\nUpdate Frequency:"+sharedPreferences.getString("prefUpdateFrequency","NOUPDATE");
        TextView textViewSetting =(TextView) findViewById(R.id.textViewSettings);
        textViewSetting.setText(settings);

    }
}
