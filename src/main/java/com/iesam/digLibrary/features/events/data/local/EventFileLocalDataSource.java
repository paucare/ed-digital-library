package com.iesam.digLibrary.features.events.data.local;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digLibrary.features.events.domain.Event;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

    public class EventFileLocalDataSource implements EventLocalDataSource{

        private String nameFile = "events.txt";

        private Gson gson = new Gson();

        private final Type typeList = new TypeToken<ArrayList<Event>>() {
        }.getType();
        @Override
        public void save(Event model) {
            List<Event> models = findAll();
            models.add(model);
            saveToFile(models);
        }
        @Override
        public void saveList(List<Event> models) {
            saveToFile(models);
        }

        private void saveToFile(List<Event> models) {
            try {
                FileWriter myWriter = new FileWriter(nameFile);
                myWriter.write(gson.toJson(models));
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while saving the data.");
                e.printStackTrace();
            }
        }
        @Override
        public Event findById(int id) {
            List<Event> models = findAll();
            for (Event model : models) {
                if (Objects.equals(model.eventId, id)) {
                    return model;
                }
            }
            return null;
        }
        @Override
        public List<Event> findAll() {
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
        @Override
        public void delete(int modelId) {
            List<Event> newList = new ArrayList<>();
            List<Event> models = findAll();
            for (Event model : models) {
                if (model.eventId != modelId) {
                    newList.add(model);
                }
            }
            saveList(newList);
        }
    }

