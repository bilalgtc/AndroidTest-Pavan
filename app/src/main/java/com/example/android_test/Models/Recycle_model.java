package com.example.android_test.Models;

public class Recycle_model {
//    public String id;
    public byte[] img;
    public String name;
    public String species;
    public String breed;

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
//    , byte[] img
    public Recycle_model(String name, String species, String breed, byte[] img) {
//        this.id = id;

        this.name = name;
        this.species=species;
        this.breed = breed;
        this.img=img;
    }

//    public String getId() {
//        return id;
//    }
//

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
//    public void setId(String id) {
//        this.id = id;
//    }

//    public byte[] getImg() {
//        return img;
//    }
//
//    public void setImg(byte[] img) {
//        this.img = img;
//    }

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
