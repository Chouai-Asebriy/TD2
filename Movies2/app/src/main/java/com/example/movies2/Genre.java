package com.example.movies2;

public class Genre {
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int genreId) {
        id = genreId;
    }

    public int getId() {
        return id;
    }

    public void setName(String genreName) {
        name = genreName;
    }

    public String getName() {
        return name;
    }
}
