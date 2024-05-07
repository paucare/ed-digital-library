package com.iesam.digLibrary.features.loans.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digLibrary.features.loans.domain.Loan;
import com.iesam.digLibrary.features.resources.Resources;

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

    private final Type typeList = new TypeToken<ArrayList<Resources>>() {
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
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public Loan findById(String id) {
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
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void delete(int modelId) {
        List<Loan> newList = new ArrayList<>();
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (model.loanId != modelId) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    public List<Loan> getActiveLoans() {
        List <Loan>  Loans= findAll();
        List<Loan> activeLoans = new ArrayList<>();
        for(Loan element : Loans){
            if(element.isActive()) {
                activeLoans.add(element);
            }
        }
        return activeLoans;
    }
    
    public List<Loan> getFinishedLoans(){
        List <Loan>  Loans= findAll();
        List<Loan> finishedLoans = new ArrayList<>();
        for(Loan element : Loans){
            if(!element.isActive()) {
                finishedLoans.add(element);
            }
        }
        return finishedLoans;
    }

}
