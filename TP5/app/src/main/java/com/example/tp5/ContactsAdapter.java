package com.example.tp5;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>{
    private final List<Contact> mContacts;
    public ContactsAdapter(List<Contact> contacts){
        mContacts = contacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactview = inflater.inflate(R.layout.item_contact,parent, false);
        return new ViewHolder(contactview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getFirstName());

        TextView lastNameTextView = holder.lastNameTextView;
        lastNameTextView.setText(contact.getLastName());

        ImageView image = holder.image;
        Glide.with(holder.itemView).load(contact.getImageUrl()).into(image);
        //Glide.with(holder.itemView).load("https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png").into(image);
        //image.setImageDrawable(contact.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView firstNameTextView;
        public TextView lastNameTextView;
        public ImageView image;

        public ViewHolder(View itemView){
            super(itemView);
            firstNameTextView = (TextView) itemView.findViewById(R.id.contact_firstname);
            lastNameTextView = (TextView) itemView.findViewById(R.id.contact_lastname);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
