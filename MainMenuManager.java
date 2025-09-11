package com.udacity.hotel.ui;

import java.util.Scanner;


public final class MainMenuManager implements MenuManager {

    private final MenuManager adminMenuManager;
    private final MainMenuService mainMenuService;
    private final Scanner scanner;
    private final ConsolePrinter consolePrinter;

  
    public MainMenuManager(MenuManager adminMenuManager, MainMenuService mainMenuService, Scanner scanner,
                           ConsolePrinter consolePrinter) {
        this.adminMenuManager = adminMenuManager;
        this.mainMenuService = mainMenuService;
        this.scanner = scanner;
        this.consolePrinter = consolePrinter;
    }

    
    @Override
    public void open() {
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                mainMenuService.printMenu();
                int input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1 -> mainMenuService.findAndReserveARoom();
                    case 2 -> mainMenuService.showCustomersReservations();
                    case 3 -> mainMenuService.createNewAccount();
                    case 4 -> goToAdminMenu();
                    case 5 -> {
                        consolePrinter.print("Exiting the app");
                        keepRunning = false;
                        scanner.close();
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

    private void goToAdminMenu() {
        adminMenuManager.open();
    }
}
