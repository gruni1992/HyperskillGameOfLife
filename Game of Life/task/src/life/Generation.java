package life;

import java.util.Arrays;

public class Generation {
    final static int MIN_NEIGHBOURS = 2;
    final static int MAX_NEIGHBOURS = 3;
    final static int REBORN_NEIGHBOURS = 3;

    static boolean[][] get(boolean[][] fromParent) {
        boolean[][] parent = fromParent;
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
        return child;
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
