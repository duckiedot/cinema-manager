package cinema;

import java.util.Scanner;

public class Renderer {
    private final Scanner scanner;

    public Renderer() {
        this.scanner = new Scanner(System.in);
    }

    public void displayVoid(String message) {
        System.out.println(message);
    }

    public int askForInt(String message) {
        this.displayVoid(message);
        return scanner.hasNext() ? scanner.nextInt() : 0;
    }

    public String askForString(String message) {
        this.displayVoid(message);
        return scanner.hasNext() ? scanner.nextLine() : "";
    }
}
