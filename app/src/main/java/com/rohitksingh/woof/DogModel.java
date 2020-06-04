package com.rohitksingh.woof;

import java.io.Serializable;

public class DogModel implements Serializable {

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
