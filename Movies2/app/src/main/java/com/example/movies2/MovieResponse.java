package com.example.movies2;


import java.util.List;

public class MovieResponse {
    private int page;

    private List<Movie> results = null;

    @SuppressWarnings({"unused", "used by Retrofit"})
    public MovieResponse() {
    }

    public List<Movie> getResults() {
        return results;
    }
}
