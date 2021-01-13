package Shipcounter;


import java.util.ArrayList;


public class ShipsCounter {
    static int[][] ships = {
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, },
            { 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, },
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, }
    };

    private static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); //List for checked cells

    private static int count = 0;                                             //count of ships


    public static void main(String[] args) {


        // count ships here
        System.out.println("Count of ships = " + ships_count(ships));
    }
    //counting ships
    static public int ships_count(int[][] example) {
        boolean isShip = false;
        count = 0;
        result.clear();

        for (int i = 0; i < example.length; i++) {
            for (int j = 0; j < example[i].length; j++) {

                int x = j;
                int y = i;
                isShip = false;

                check(x, y, example, isShip);


            }

        }
        return count;
    }
    // check cells neighbour
    static private void check(int x, int y, int[][] example, boolean isShip){

        ArrayList<Integer> xy = new ArrayList<Integer>();
        xy.add(x);
        xy.add(y);

        if (inExample(x, y, example) && !result.contains(xy)){
            if (example[x][y] == 1) {
                if (!isShip) count++;

                isShip = true;

                result.add(xy);

                //up cell
                check(x, y-1, example, isShip);
                //left, right
                check(x-1, y, example, isShip);
                check(x+1, y, example, isShip);
                //down
                check(x, y+1, example, isShip);
            }

        }

    }
    //checking cell not out of bound
    static private boolean inExample(int x, int y, int[][] example){
        if (x < 0 || y < 0) return false;
        else if (x >= example[0].length || y >= example.length) return false;

        return true;
    }



}



