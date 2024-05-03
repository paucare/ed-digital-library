package com.iesam.digLibrary.features.resources.data.local;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digLibrary.features.resources.domain.Resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class ResourcesFileLocalDataSource {
        private String nameFile = "resources.txt";

        private Gson gson = new Gson();

        private final Type typeList = new TypeToken<ArrayList<Resources>>() {
        }.getType();

        public void save(Resources model) {
            List<Resources> models = findAll();
            models.add(model);
            saveToFile(models);
        }

        public void saveList(List<Resources> models) {
            saveToFile(models);
        }

        private void saveToFile(List<Resources> models) {
            try {
                FileWriter myWriter = new FileWriter(nameFile);
                myWriter.write(gson.toJson(models));
                myWriter.close();
                System.out.println("Datos guardados correctamente");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al guardar la información.");
                e.printStackTrace();
            }
        }

        public Resources findById(String id) {
            List<Resources> models = findAll();
            for (Resources model : models) {
                if (Objects.equals(model.id, id)) {
                    return model;
                }
            }
            return null;
        }

        public List<Resources> findAll() {
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
                System.out.println("Ha ocurrido un error al obtener el listado.");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al crear el fichero.");
                throw new RuntimeException(e);
            }
            return new ArrayList<>();
        }

        public void delete(int modelId) {
            List<Resources> newList = new ArrayList<>();
            List<Resources> models = findAll();
            for (Resources model : models) {
                if (model.id != modelId) {
                    newList.add(model);
                }
            }
            saveList(newList);
        }
}
