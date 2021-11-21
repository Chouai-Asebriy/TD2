package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String login = app.getLogin();
        TextView loginText = (TextView)findViewById(R.id.msgBienvenueDetails);
        loginText.setText("Bienvenue "+login);
    }
}
