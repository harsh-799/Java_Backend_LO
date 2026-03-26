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
    @Basic(fetch = FetchType.LAZY) // Using this we will only get the image when we ask for it not at the time of getting the dog, iT comes at the time of getting the dogImages().
    byte [] images;

    /*
    🔥 Industry advice:
    👉 Storing images in DB is NOT recommended for large scale

    Instead:
    Store image in file system / cloud
    Save only path in DB
     */

    /*
    - 🧩 Now since there were no Relations so we defined it above the field which will be having big data with @Basic(fetch = FetchType.LAZY).
    - 🧩 Now if there's realtionship case in that describe the loading way inside the @OneToMany(here itself).
    - 🧩 Make sure you know the default loading type before describing anything
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
