package life;

import java.util.Random;

public class GameOfLifeModel {
    private boolean[][] universe;
    private int generation = 0;
    final static int MIN_NEIGHBOURS = 2;
    final static int MAX_NEIGHBOURS = 3;
    final static int REBORN_NEIGHBOURS = 3;


    public GameOfLifeModel(){
        this(20);
    }

    public GameOfLifeModel(int size) { this(size, 0); }

    public GameOfLifeModel(int size, int seed){
        this(size, seed, 0);
    }

    public GameOfLifeModel(int size, int seed, int evolutions) {
        Random random = seed == 0 ? new Random() : new Random(seed);
        boolean[][] universe = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = random.nextBoolean();
            }
        }
        this.universe = universe;
        for (int i = 0; i < evolutions; i++) {
            evolve();
        }
    }

    public int getAlive(){
        int alive = 0;
        for (boolean[] line : universe) {
            for (boolean cell : line) {
                alive += cell ? 1 : 0;
            }
        }
        return alive;
    }

    public boolean[][] getUniverse() {
        return universe;
    }

    public void setUniverse(boolean[][] universe) {
        this.universe = universe;
    }

    public int getGeneration(){
        return generation;
    }

    public void printUniverse() {
        System.out.println("Generation: #" + generation);
        System.out.println("Alive: " + getAlive());
        for (boolean[] line : universe) {
            StringBuilder builder = new StringBuilder();
            for (boolean cell : line) {
                builder.append(cell ? "O" : " ");
            }
            System.out.println(builder.toString());
        }
    }

    void evolve() {
        boolean[][] parent = universe;
        int[][] neighbours = getNeighbours(parent);
        boolean[][] child = new boolean[parent.length][parent.length];
        for (int i = 0; i < neighbours.length; i++) {
            for (int j = 0; j < neighbours[i].length; j++) {
                //If current cell is alive
                if (parent[i][j]){
                    //An alive cell survives if has between min and max alive neighbors;
                    child[i][j] = neighbours[i][j] >= MIN_NEIGHBOURS && neighbours[i][j] <= MAX_NEIGHBOURS;
                } else {
                    //A dead cell is reborn if it has exactly the specified number of alive neighbors
                    child[i][j] = neighbours[i][j] == REBORN_NEIGHBOURS;
                }

            }
        }
        generation++;
        universe = child;
    }

    static int[][] getNeighbours (boolean[][] parent){
        int[][] result = new int[parent.length][parent.length];
        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < parent[i].length; j++) {
                int numberOfNeighbours = 0;
                int l = parent.length;
                numberOfNeighbours += parent[(i-1+l)%l][(j-1+l)%l] ? 1 : 0;
                numberOfNeighbours += parent[(i-1+l)%l][j] ? 1 : 0;
                numberOfNeighbours += parent[(i-1+l)%l][(j+1)%l] ? 1 : 0;
                numberOfNeighbours += parent[i][(j-1+l)%l] ? 1 : 0;
                numberOfNeighbours += parent[i][(j+1)%l] ? 1 : 0;
                numberOfNeighbours += parent[(i+1)%l][(j-1+l)%l] ? 1 : 0;
                numberOfNeighbours += parent[(i+1)%l][j] ? 1 : 0;
                numberOfNeighbours += parent[(i+1)%l][(j+1)%l] ? 1 : 0;
                result[i][j] = numberOfNeighbours;
            }
        }
        return result;
    }
}
