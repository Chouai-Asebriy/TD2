package com.example.td6;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder>{
    private final List<Repo> mRepos;
    public RepoAdapter(List<Repo> repos){
        mRepos = repos;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactview = inflater.inflate(R.layout.item_repo,parent, false);
        return new ViewHolder(contactview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = mRepos.get(position);

        TextView nameTextView = holder.nameTextView;
        nameTextView.setText(repo.getName());

        TextView fullNameTextView = holder.fullNameTextView;
        fullNameTextView.setText(repo.getFull_name());

        TextView htmlUrlTextView = holder.htmlUrlTextView;
        htmlUrlTextView.setText(repo.getHtml_url());
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView fullNameTextView;
        public TextView htmlUrlTextView;

        public ViewHolder(View itemView){
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.repo_name);
            fullNameTextView = (TextView) itemView.findViewById(R.id.repo_fullname);
            ((TextView) itemView.findViewById(R.id.repo_htmlurl)).setMovementMethod(LinkMovementMethod.getInstance());
            htmlUrlTextView = (TextView) itemView.findViewById(R.id.repo_htmlurl);
        }
    }
}
