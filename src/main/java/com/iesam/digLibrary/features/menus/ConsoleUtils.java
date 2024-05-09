package com.iesam.digLibrary.features.menus;

import java.io.IOException;

public class ConsoleUtils {
        public static void clearConsole() {
            for(int clear = 0; clear < 30; clear++) {
                System.out.println("\b") ;
            }
        }
}
