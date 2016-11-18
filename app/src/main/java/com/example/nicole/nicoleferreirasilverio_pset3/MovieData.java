package com.example.nicole.nicoleferreirasilverio_pset3;

/**
 * Created by Nicole on 18-11-2016.
 */

public class MovieData {
    public String title;
    public String year;
    public String director;
    public String plot;
    public String actors;
    public String imageURL;

    public MovieData(String title, String year, String imageURL){
        this.title = title;
        this.year = year;
        this.imageURL = imageURL;
    }

    public String getTitle(){
        return title;
    }

    public String getYear(){
        return year;
    }

    public String getImageURL(){
        return imageURL;
    }
}
