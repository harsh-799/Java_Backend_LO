package com.harsh.hibernate.model;

import jakarta.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int dogId;
    String dogName;

    @Lob
    @Column(name = "dogprofile_photo",columnDefinition = "LONGBLOB")
    byte [] images;

    /*
    🔥 Industry advice:
    👉 Storing images in DB is NOT recommended for large scale

    Instead:
    Store image in file system / cloud
    Save only path in DB
     */

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }
}
