package com.udacity.hotel.ui;

import java.util.*;

public final class AdminMenuManager implements MenuManager {

    private final AdminMenuService adminMenuService;
    private final Scanner scanner;
    private final ConsolePrinter consolePrinter;

   
    public AdminMenuManager(Scanner scanner, AdminMenuService adminMenuService, ConsolePrinter consolePrinter) {
        this.adminMenuService = adminMenuService;
        this.scanner = scanner;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void open() {
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                adminMenuService.printMenu();
                int input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1 -> adminMenuService.showAllCustomers();
                    case 2 -> adminMenuService.showAllRooms();
                    case 3 -> adminMenuService.showAllReservations();
                    case 4 -> adminMenuService.addARoom();
                    case 5 -> {
                        consolePrinter.print("Returning to the main menu");
                        keepRunning = false;
                    }
                    default -> consolePrinter.print("Please enter a number representing a menu option from above");
                }
            } catch (NumberFormatException ex) {
                consolePrinter.print("Please enter a number");
            } catch (IllegalArgumentException ex) {
                consolePrinter.print(ex.getLocalizedMessage());
            } catch (Exception ex) {
                consolePrinter.print("Unknown error occurred.");
                consolePrinter.print(ex.getLocalizedMessage());
            }
        }
    }
}
