package com.iesam.digLibrary.features.loans.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digLibrary.features.loans.domain.Loan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LoanFileLocalDataSource {
    private String nameFile = "loans.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Loan>>() {
    }.getType();

    public void save(Loan model) {
        List<Loan> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Loan> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Loan> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the data.");
            e.printStackTrace();
        }
    }

    public Loan findById(long id) {
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (Objects.equals(model.loanId, id)) {
                return model;
            }
        }
        return null;
    }

    public List<Loan> findAll() {
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

    public void delete(long modelId) {
        List<Loan> newList = new ArrayList<>();
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (model.loanId != modelId) {
                newList.add(model);
            }
        }
        saveList(newList);
    }
}
