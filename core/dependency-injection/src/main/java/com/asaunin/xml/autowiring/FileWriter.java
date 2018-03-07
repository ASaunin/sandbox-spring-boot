package com.asaunin.xml.autowiring;

public class FileWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println("File output: " + msg);
    }

}
