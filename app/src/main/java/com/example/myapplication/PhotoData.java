package com.example.myapplication;
import android.animation.ObjectAnimator;
import android.content.Context;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotoData {
    private static Context context;
    public static void init(Context context) {
        PhotoData.context = context;
    }

    private static String loadJSONFromAsset(String fileName) throws IOException {
        String jsonString;
        InputStream inputStream = context.getAssets().open(fileName);
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        jsonString = new String(buffer, "UTF-8");
        return jsonString;
    }

    public static ArrayList<Photo> readPhotoJSONFile() {
        ArrayList<Photo> photoArrayList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //photoArrayList = objectMapper.readValue(jsonString, new TypeReference<ArrayList<Photo>>() {});
            photoArrayList = objectMapper.readValue(loadJSONFromAsset("photo.json"), new TypeReference<ArrayList<Photo>>() {});
            return photoArrayList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return photoArrayList;
    }
    public static Photo getPhotoFromId(int id){

        ArrayList<Photo> phs = readPhotoJSONFile();
        for(int i=0;i<phs.size();i++){
            if(phs.get(i).getId() == id){
                return phs.get(i);
            }
        }
        return null;
    }

}
