package com.example.movies2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private Context context;
    public static final String BASE_URL = "https://image.tmdb.org/t/p/w500";
    private final List<Movie> movies;
    public MovieAdapter(List<Movie> lMovies){
        movies = lMovies;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieview = inflater.inflate(R.layout.item_movie,parent, false);
        return new ViewHolder(movieview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Movie movie = movies.get(position);
        ImageView image = holder.image;
        Glide.with(holder.itemView).load(BASE_URL+movie.getPoster_path()).into(image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("movie",movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView movieTitle;
        public ViewHolder(View itemView){
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.movieImage);
        }
    }
}
