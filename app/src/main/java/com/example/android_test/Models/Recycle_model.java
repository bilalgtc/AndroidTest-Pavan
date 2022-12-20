package com.example.android_test.Models;

public class Recycle_model {
    public String id;
    public byte[] img;
    public String name;
    public String species;
    public String breed;
    public String size;
    public String gender;
    public String neutured;
    public String vaccinated;
    public String fwithdogs;
    public String fwithcats;
    public String fwithkids;
    public String getFwithkidssg;


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNeutured() {
        return neutured;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Recycle_model(String id, byte[] img, String name, String species, String breed, String size, String gender, String neutured, String vaccinated, String fwithdogs, String fwithcats, String fwithkids, String getFwithkidssg) {
        this.id=id;
        this.img = img;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.size = size;
        this.gender = gender;
        this.neutured = neutured;
        this.vaccinated = vaccinated;
        this.fwithdogs = fwithdogs;
        this.fwithcats = fwithcats;
        this.fwithkids = fwithkids;
        this.getFwithkidssg = getFwithkidssg;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getFwithdogs() {
        return fwithdogs;
    }

    public void setFwithdogs(String fwithdogs) {
        this.fwithdogs = fwithdogs;
    }

    public String getFwithcats() {
        return fwithcats;
    }

    public void setFwithcats(String fwithcats) {
        this.fwithcats = fwithcats;
    }

    public String getFwithkids() {
        return fwithkids;
    }

    public void setFwithkids(String fwithkids) {
        this.fwithkids = fwithkids;
    }

    public String getGetFwithkidssg() {
        return getFwithkidssg;
    }

    public void setGetFwithkidssg(String getFwithkidssg) {
        this.getFwithkidssg = getFwithkidssg;
    }

    public void setNeutured(String neutured) {
        this.neutured = neutured;
    }

//    String neutured, String vaccinated, String fwithdogs, String fwithcats, String fwithkids, String getFwithkidssg


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getImg() {
        return img;
    }
    public void setImg(byte[] img) {
        this.img = img;
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
