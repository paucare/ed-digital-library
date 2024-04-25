package com.iesam;
import java.util.Scanner;

import com.iesam.digLibrary.features.user.domain.User;
import com.iesam.digLibrary.features.user.presentation.UserPresentation;


public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {


        int option = -1;

        do {
            System.out.println("Menu");
            System.out.println("0. Salir");
            System.out.println("1. Dar de alta un usuario");
            option = sc.nextInt();
            if (option > 0) {
                menuHandler(option);
            }

        } while (option != 0);
    }
    public static void menuHandler(int option){
        switch(option){
            case 1: UserPresentation.showUserForm();
            System.out.println("Siguiente operación");
            return;

            default:
                return;
        }
    }
}