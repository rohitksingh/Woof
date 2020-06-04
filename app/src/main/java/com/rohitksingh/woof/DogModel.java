package com.rohitksingh.woof;

public class DogModel {

    private String imageUrl;

    public DogModel(){

    }

    public DogModel(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
