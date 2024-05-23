package com.iesam.digLibrary.features.resources.books.data.local;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digLibrary.features.resources.books.domain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class BooksFileLocalDataSource {
        private String nameFile = "books.txt";

        private Gson gson = new Gson();

        private final Type typeList = new TypeToken<ArrayList<Books>>() {
        }.getType();

        public void save(Books model) {
            List<Books> models = findAll();
            models.add(model);
            saveToFile(models);
        }

        public void saveList(List<Books> models) {
            saveToFile(models);
        }

        private void saveToFile(List<Books> models) {
            try {
                FileWriter myWriter = new FileWriter(nameFile);
                myWriter.write(gson.toJson(models));
                myWriter.close();
                //System.out.println("Datos guardados correctamente");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al guardar la información.");
                e.printStackTrace();
            }
        }

        public Books findById(int id) {
            List<Books> models = findAll();
            for (Books model : models) {
                if (Objects.equals(model.id, id)) {
                    return model;
                }
            }
            return null;
        }

        public List<Books> findAll() {
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
            List<Books> newList = new ArrayList<>();
            List<Books> models = findAll();
            for (Books model : models) {
                if (model.id != modelId) {
                    newList.add(model);
                }
            }
            saveList(newList);
        }
}
