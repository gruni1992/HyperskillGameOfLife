package life;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = scanner.nextInt();
        int evolutions = scanner.nextInt();
        Universe universe = new Universe(size, seed, evolutions);
        universe.printState();
    }
}
