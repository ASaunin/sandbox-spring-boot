package xml.autowiring;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println("Console output: " + msg);
    }

}
