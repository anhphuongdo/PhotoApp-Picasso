package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title_photo;
    @SerializedName("desciption")
    private String description_photo;
    @SerializedName("source")
    private String source_photo;

    public Photo( ){}

    public Photo(int id, String title_photo, String description_photo, String source_photo) {
        this.id = id;
        this.title_photo = title_photo;
        this.description_photo = description_photo;
        this.source_photo = source_photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_photo() {
        return title_photo;
    }

    public void setTitle_photo(String title_photo) {
        this.title_photo = title_photo;
    }

    public String getDescription_photo() {
        return description_photo;
    }

    public void setDescription_photo(String description_photo) {
        this.description_photo = description_photo;
    }

    public String getSource_photo() {
        return source_photo;
    }

    public void setSource_photo(String source_photo) {
        this.source_photo = source_photo;
    }
}
