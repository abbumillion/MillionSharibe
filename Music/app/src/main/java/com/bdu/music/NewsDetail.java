package com.bdu.music;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewsDetail extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        textView=findViewById(R.id.detail);
        String[] news_detail=getIntent().getStringArrayExtra("news");
        textView.setText(news_detail[2]);
    }
}
