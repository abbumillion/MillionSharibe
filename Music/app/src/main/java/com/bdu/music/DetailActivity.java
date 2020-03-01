package com.bdu.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
     TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String[] userData=getIntent().getStringArrayExtra("user");
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        t3=findViewById(R.id.textView4);
        t4=findViewById(R.id.textView5);
        t5=findViewById(R.id.textView6);
        t6=findViewById(R.id.textView7);
        t1.setText(userData[0]);
        t2.setText(userData[1]);
        t3.setText(userData[2]);
        t4.setText(userData[3]);
        t5.setText(userData[4]);
        t6.setText(userData[5]);
        logout=findViewById(R.id.logout2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                intent.putExtra("logout",1);
                startActivity(intent);
            }
        });

    }
}
