package com.example.tp5;

public class Contact {
    private String firstName;
    private String lastName;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Contact(String firstName, String lastName, String imageUrl){
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
