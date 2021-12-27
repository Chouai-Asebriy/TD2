package com.example.movies2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    public static final String ENDPOINT = "https://api.themoviedb.org/3/";

    @GET("movie/popular")
    Call<MovieResponse> listPopularMovies(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/upcoming")
    Call<MovieResponse> listUpcomingMovies(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("genre/movie/list")
    Call<GenresResponse> getAllGenres(@Query("api_key") String apiKey);

}
