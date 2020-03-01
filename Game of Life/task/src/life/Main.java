package life;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = scanner.nextInt();
        boolean[][] universe = createUniverse(size, seed);
        printUniverse(universe);
    }

    public static void printUniverse(boolean[][] universe) {
        for (boolean[] line : universe) {
            StringBuilder builder = new StringBuilder();
            for (boolean cell : line) {
                builder.append(cell ? "O" : " ");
            }
            System.out.println(builder.toString());
        }
    }

    public static boolean[][] createUniverse(int size, int seed) {
        Random random = new Random(seed);
        boolean[][] universe = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = random.nextBoolean();
            }
        }
        return universe;
    }
}
