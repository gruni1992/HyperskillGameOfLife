package life;

import java.util.Arrays;
import java.util.Random;

public class Universe {
    private boolean[][] state;
    int generation = 1;


    public Universe(){
        this(5, 0);
    }

    public Universe(int size, int seed){
        this(size, seed, 0);
    }

    public Universe(int size, int seed, int evolutions) {
        Random random = new Random(seed);
        boolean[][] universe = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = random.nextBoolean();
            }
        }
        for (int i = 0; i < evolutions; i++) {
            universe = Generation.get(universe);
        }
        this.state = universe;
    }

    public void evolve(){
        generation++;
        state = Generation.get(state);
    }

    public int countAlive(){
        int alive = 0;
        for (boolean[] line : state) {
            for (boolean cell : line) {
                alive += cell ? 1 : 0;
            }
        }
        return alive;
    }

    public boolean[][] getState() {
        return state;
    }

    public void setState(boolean[][] state) {
        this.state = state;
    }

    public void printState() {
        System.out.println("Generation: #" + generation);
        System.out.println("Alive: " + countAlive());
        for (boolean[] line : state) {
            StringBuilder builder = new StringBuilder();
            for (boolean cell : line) {
                builder.append(cell ? "O" : " ");
            }
            System.out.println(builder.toString());
        }
    }
}
