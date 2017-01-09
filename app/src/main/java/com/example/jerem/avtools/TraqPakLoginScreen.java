package com.example.jerem.avtools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class TraqPakLoginScreen extends AppCompatActivity {

    TextInputEditText tUsername;
    TextInputEditText tPassword;
    CheckBox tRemember;
    Button btnLogin;
    public static String PREF_USERNAME="username";
    public static String PREF_PASSWORD="password";
    public static String  PREFS_REMEMBER="remember";
    String username="";
    String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traq_pak_login_screen);

        tUsername=(TextInputEditText) findViewById(R.id.tUsername);
        tPassword=(TextInputEditText)findViewById(R.id.tPassword);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username=tUsername.getText().toString();
                password=tPassword.getText().toString();

                tRemember=(CheckBox)findViewById(R.id.traqRemember);

                if(tRemember.isChecked()){

                    rememberMe(username, password);
                Toast.makeText(getApplicationContext(), "Username set to "+username+" Password set to "+password,Toast.LENGTH_LONG).show();
                Intent i = new Intent(TraqPakLoginScreen.this, MainActivity.class);
                startActivity(i);}
            }
        });
    }

    public void onStart(){
        super.onStart();
        getUser();
    }
    public void doLogin(View view){
        tUsername=(TextInputEditText) findViewById(R.id.tUsername);
        tPassword=(TextInputEditText)findViewById(R.id.tPassword);
        String username=tUsername.getText().toString();
        String password=tPassword.getText().toString();
            tRemember=(CheckBox)findViewById(R.id.traqRemember);
            if(tRemember.isChecked())
                rememberMe(username, password);
        else{
            Toast.makeText(this, "Invalid username or password",Toast.LENGTH_LONG).show();
        }
    }

    public void getUser(){
        SharedPreferences pref = getSharedPreferences(PREFS_REMEMBER,MODE_PRIVATE);
        String usernameGottn = pref.getString(PREF_USERNAME, null);
        String passwordGottn = pref.getString(PREF_PASSWORD, null);

        if (usernameGottn != null || passwordGottn != null) {
            tUsername.setText(usernameGottn);
            tPassword.setText(passwordGottn);
        }
    }

    public void rememberMe(String username, String password){
        //save username and password in SharedPreferences
        getSharedPreferences(PREFS_REMEMBER,MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME,username)
                .putString(PREF_PASSWORD,password)
                .apply();
    }
}
