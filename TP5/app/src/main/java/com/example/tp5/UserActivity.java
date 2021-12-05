package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //Lookup the recyclerView in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        //Initialization of contacts
        contacts.add(new Contact("Jean","Pierre","https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png"));
        contacts.add(new Contact("Jeanne","D'arc","https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png"));
        contacts.add(new Contact("Pierre","Menez","https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png"));
        contacts.add(new Contact("Arthur","Rimbaut","https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png"));
        contacts.add(new Contact("Richard","Coeur de lion","https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png"));
        contacts.add(new Contact("Zinedine","Zidane","https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png"));
        contacts.add(new Contact("Yannick","Noah","https://cdn.iconscout.com/icon/free/png-256/developer-2309906-1943816.png"));

        //Création d'un adapter avec initialisation du constructeur avec notre liste de contacts
        ContactsAdapter adapter= new ContactsAdapter(contacts);
        //On notifie au RecyclerView notre adapter
        rvContacts.setAdapter(adapter);
        //On déclare quel type de LayoutManager on désire
        rvContacts.setLayoutManager(new LinearLayoutManager(this));


    }
}


