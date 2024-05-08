package com.iesam.digLibrary.features.user.domain;

public class User {
  
    public final String dni;
    public final String name;
    public final String surname;
    public final int phoneNumber;
    public final String address;

    public User(String dni, String name, String surname, int phoneNumber, String address) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
