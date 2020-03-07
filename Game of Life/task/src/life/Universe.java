package life;

import java.util.Random;

public class Universe {
    private boolean[][] state;


    public Universe(){
        this(5, 0);
    }

    public Universe(int size, int seed){
        Random random = new Random(seed);
        boolean[][] universe = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = random.nextBoolean();
            }
        }
        this.state = universe;
    }

    public void printState() {
        for (boolean[] line : state) {
            StringBuilder builder = new StringBuilder();
            for (boolean cell : line) {
                builder.append(cell ? "O" : " ");
            }
            System.out.println(builder.toString());
        }
    }
}
