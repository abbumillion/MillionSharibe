package com.bdu.music;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity  {
        Button login;
        TextView signup;
        EditText email;
        EditText password;
        DatabaseHelper databaseHelper;
     SharedPreferenceConf sharedPreference;
    String[] userdata;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login_login);
        signup=findViewById(R.id.register_login);
        email=findViewById(R.id.email_login);
        password=findViewById(R.id.password_login);
        imageButton=findViewById(R.id.popuyt);
        final AlertDialog.Builder	myAlertBuilder	=	new AlertDialog.Builder(LoginActivity.this);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup	=	new	PopupMenu(getApplicationContext(),	imageButton);
                //Inflating	the	Popup	using	xml	file
                popup.getMenuInflater().inflate(R.menu.pop,	popup.getMenu());
                popup.show();
                // registering	popup	with	OnMenuItemClickListener
                 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                     @Override
                     public boolean onMenuItemClick(MenuItem item) {
                         myAlertBuilder.setTitle("Alert");
                         myAlertBuilder.setMessage("do something here");
                         myAlertBuilder.show();
                         return false;
                     }
                 });
            }
        });
        databaseHelper=new DatabaseHelper(getApplicationContext());
       // final boolean status=databaseHelper.getDataForLogin(email.getText().toString());
        sharedPreference= new SharedPreferenceConf(getApplicationContext());
        if(sharedPreference.readLogInStatus()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                Boolean userdata=databaseHelper.getDataForLogin(e);
                try {
                    if (e.isEmpty() && p.isEmpty()) {
                        myAlertBuilder.setTitle("Alert");
                        myAlertBuilder.setMessage("please enter email and password");
                        myAlertBuilder.show();
                    } else {
                        if (userdata) {
                            myAlertBuilder.setTitle("Alert");
                            myAlertBuilder.setMessage("Logged successfully");
                            myAlertBuilder.show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            sharedPreference.writeLogInStatus(true);
                        } else {
                            myAlertBuilder.setTitle("Alert");
                            myAlertBuilder.setMessage("wrong email and password try again");
                            myAlertBuilder.show();
                        }
                    }
                }catch (Exception ex){
                    myAlertBuilder.setTitle("Alert");
                    myAlertBuilder.setMessage("something went wrong");
                    myAlertBuilder.show();
                }
                }

        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}