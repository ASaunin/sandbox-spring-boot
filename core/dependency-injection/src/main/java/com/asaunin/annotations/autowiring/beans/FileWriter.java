package com.asaunin.annotations.autowiring.beans;

import com.asaunin.annotations.autowiring.Writer;

public class FileWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println("File output: " + msg);
    }

}
