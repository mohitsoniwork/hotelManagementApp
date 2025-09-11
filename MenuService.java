package com.udacity.hotel.ui;

import java.util.Scanner;


abstract class MenuService {

    final Scanner scanner;

 
    MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

 
    public abstract void printMenu();

    boolean isNumber(String strInt) {
        if (strInt == null) {
            return false;
        }
        try {
            Double.parseDouble(strInt);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
