package com.example.movies2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_popular_movies);

        RecyclerView rvRepos = (RecyclerView) findViewById(R.id.rvPopular);

            MovieService movieService = new Retrofit.Builder()
                    .baseUrl(MovieService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MovieService.class);

            movieService.listMovies("92d9807be90ba6c492aaa7e6a4893a46",1).enqueue(new Callback<List<Movie>>() {
                @Override
                public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                    afficherMovies(response.body());
                    //Création d'un adapter avec initialisation du constructeur avec notre liste de contacts
                    MovieAdapter adapter= new MovieAdapter(response.body());
                    //On notifie au RecyclerView notre adapter
                    rvRepos.setAdapter(adapter);
                    //On déclare quel type de LayoutManager on désire
                    rvRepos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onFailure(Call<List<Movie>> call, Throwable t) {
                    t.getCause();
                }
            });


    }
    public void afficherMovies(List<Movie> movies) {
        Toast.makeText(this,"nombre de dépots : "+movies.size(), Toast.LENGTH_SHORT).show();
    }

}
