package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {
    String nom;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle(getLocalClassName());
        editText = (EditText)findViewById(R.id.nomUser);
        Button rollButton = (Button) findViewById(R.id.login);
        if(editText != null)
        {
            rollButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nom = editText.getText().toString();

                    NewsListApplication app = (NewsListApplication) getApplicationContext();
                    app.setLogin(nom);

                    Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                    intent.putExtra("login",nom);
                    startActivity(intent);
                    onBackPressed();
                }
            });
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
