package com.example.android_test.Models;

public class Recycle_model {
    public String id;
    public String image;
    public String name;
    public String species;
    public String breed;
    public String size;
    public String gender;
    public String neutered;
    public String vaccinated;
    public String Friendlywithdogs;
    public String Friendlywithcats;
    public String Friendlywithkids10;
    public String Friendlywithkids10G;

    public Recycle_model() {

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNeutered() {
        return neutered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Recycle_model(String image, String name, String species, String breed, String size, String gender, String neutered, String vaccinated, String Friendlywithdogs, String Friendlywithcats, String Friendlywithkids10, String Friendlywithkids10G) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.size = size;
        this.gender = gender;
        this.neutered = neutered;
        this.vaccinated = vaccinated;
        this.Friendlywithdogs = Friendlywithdogs;
        this.Friendlywithcats = Friendlywithcats;
        this.Friendlywithkids10 = Friendlywithkids10;
        this.Friendlywithkids10G = Friendlywithkids10G;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getFwithdogs() {
        return Friendlywithdogs;
    }

    public void setFwithdogs(String Friendlywithdogs) {
        this.Friendlywithdogs = Friendlywithdogs;
    }

    public String getFwithcats() {
        return Friendlywithcats;
    }

    public void setFwithcats(String fwithcats) {
        this.Friendlywithcats = fwithcats;
    }

    public String getFwithkids() {
        return Friendlywithkids10;
    }

    public void setFwithkids(String Friendlywithkids10) {
        this.Friendlywithkids10 = Friendlywithkids10;
    }

    public String getGetFwithkidssg() {
        return Friendlywithkids10G;
    }

    public void setGetFwithkidssg(String Friendlywithkids10G) {
        this.Friendlywithkids10G = Friendlywithkids10G;
    }

    public void setNeutered(String neutured) {
        this.neutered = neutured;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
//


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
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
