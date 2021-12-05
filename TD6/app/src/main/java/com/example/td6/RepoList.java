package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);

        RecyclerView rvRepos = (RecyclerView) findViewById(R.id.rvRepos);

        Intent intent = getIntent();
        String repoName;
        if (intent.hasExtra("repoName")){
            repoName = intent.getStringExtra("repoName");

            GithubService githubService = new Retrofit.Builder()
                    .baseUrl(GithubService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GithubService.class);

            githubService.listRepos(repoName).enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    afficherRepos(response.body());
                    //Création d'un adapter avec initialisation du constructeur avec notre liste de contacts
                    RepoAdapter adapter= new RepoAdapter(response.body());
                    //On notifie au RecyclerView notre adapter
                    rvRepos.setAdapter(adapter);
                    //On déclare quel type de LayoutManager on désire
                    rvRepos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {
                    t.getCause();
                }
            });
        }

    }
    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this,"nombre de dépots : "+repos.size(), Toast.LENGTH_SHORT).show();
    }
}
