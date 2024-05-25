package com.iesam.digLibrary.features.resources.music.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digLibrary.features.resources.music.domain.Music;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MusicFileLocalDataSource {
    private String nameFile = "music.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Music>>() {
    }.getType();

    public void save(Music model) {
        List<Music> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Music> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Music> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data.");
            e.printStackTrace();
        }
    }

    public Music findById(int id) {
        List<Music> models = findAll();
        for (Music model : models) {
            if (Objects.equals(model.id, id)) {
                return model;
            }
        }
        return null;
    }

    public List<Music> findAll() {
        try {
            File myObj = new File(nameFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while retrieving the list.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void delete(int modelId) {
        List<Music> newList = new ArrayList<>();
        List<Music> models = findAll();
        for (Music model : models) {
            if (model.id != modelId) {
                newList.add(model);
            }
        }
        saveList(newList);
    }
}
