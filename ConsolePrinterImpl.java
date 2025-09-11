package com.udacity.hotel.ui;


public final class ConsolePrinterImpl implements ConsolePrinter {


    @Override
    public <T> void print(T text) {
        System.out.println(text);
    }
}
