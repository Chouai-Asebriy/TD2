package com.example.movies2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    public static final String ENDPOINT = "https://developers.themoviedb.org/3/movies/get-popular-movies";

    @GET("/movie/popular/{page}")
    Call<List<Movie>> listMovies(@Query("api_key") String apiKey, @Path("page") int page);

}
