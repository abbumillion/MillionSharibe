package com.bdu.music;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   FrameLayout frameLayout;
   FragmentManager fragmentManager;
   FragmentTransaction fragmentTransaction;
   BottomNavigationView bottomNavigationView;
   Home home;
   Profile profile;
   Dashboard dashboard;
   Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.frame);
        bottomNavigationView=findViewById(R.id.btmnav);
        AlertDialog.Builder	myAlertBuilder	=	new AlertDialog.Builder(MainActivity.this);
        home=new Home(getApplicationContext());
        Fragment_changer(home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.dashboard:
                        dashboard=new Dashboard(getApplicationContext());
                        Fragment_changer(dashboard);
                        break;
                    case R.id.profile:
                       profile=new Profile(getApplicationContext());
                        Fragment_changer(profile);
                        break;
                    case R.id.home:
                        home=new Home(getApplicationContext());
                        Fragment_changer(home);
                        break;
                    case  R.id.settings:
                        settings=new Settings();
                        Fragment_changer(settings);
                }
                return false;
            }
        });
    }
    public void Fragment_changer(Fragment fragment)
    {
        frameLayout.removeAllViews();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}
