package annotations.autowiring.beans;

import annotations.autowiring.Writer;

public class FileWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println("File output: " + msg);
    }

}
