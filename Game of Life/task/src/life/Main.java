package life;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = 0;//scanner.nextInt();
        int evolutions = 10;//scanner.nextInt();
        Universe universe = new Universe(size, seed);
        universe.printState();
        for (int i = 0; i < evolutions; i++) {
            try {
                clearScreen();
                Thread.sleep(1000);
                universe.evolve();
                universe.printState();
            }
            catch (InterruptedException e) {}
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
