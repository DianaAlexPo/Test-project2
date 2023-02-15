import java.util.Arrays;
import java.util.Random;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int sizeArray = 5; // from 3 to 10
        int column = 2; // for sort

        int[][] array = new int[sizeArray][sizeArray];
        Random r = new Random();

        for(int i = 0; i < sizeArray; i++){
            for(int j = 0; j < sizeArray; j++){
                array[i][j] = r.nextInt(1000);
            }
        }

        // write random number
        FileWriter nFile = new FileWriter("output.txt");
        for(int i = 0; i < sizeArray; i++){
            for(int j = 0; j < sizeArray; j++){
                nFile.write(String.format("%5s", array[i][j]));
            }
            nFile.write("\n");
        }
        nFile.write("\n");

        array = Sort(array, column-1);

        // write answer
        for(int i = 0; i < sizeArray; i++){
            for(int j = 0; j < sizeArray; j++){
                nFile.write(String.format("%5s", array[i][j]));
            }
            nFile.write("\n");
        }
        nFile.close();
    }

    public static int[][] Sort(int[][] array, int column) {
        if (array.length == 0){
            return array;
        }
        int[] temp = new int[array[0].length];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i][column] < array[i - 1][column]) {
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    changed = true;
                }
            }
        }
        return array;
    }
}
