package com.example.android_test.Models;

public class Recycle_model {
//    public String id;
    public byte[] img;
    public String name;
    public String breed;

    public Recycle_model(byte[] img, String name, String breed) {
//        this.id = id;
        this.img = img;
        this.name = name;
        this.breed = breed;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
       return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
