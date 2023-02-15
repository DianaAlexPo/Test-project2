import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //read file
        FileReader fr= new FileReader("input.txt");
        Scanner scan = new Scanner(fr);
        String str = scan.nextLine();//first line from "input"
        String word = scan.nextLine();//second line from "input"
        fr.close();

        String[] words = str.split(" ");

        //make HashMap (keys = words, values = count)
        HashMap<String,Integer> keyValue = new HashMap<String,Integer>();
        for (int i=0; i<= words.length-1; i++) {
            if (keyValue.containsKey(words[i])) {
                int counter = keyValue.get(words[i]);
                keyValue.put(words[i], counter+1);
            }
            else {
                keyValue.put(words[i], 1);
            }
        }

        System.out.println(keyValue.get(word));

        //write answer
        FileWriter nFile = new FileWriter("output.txt");
        nFile.write(Integer.toString(keyValue.get(word)));
        nFile.close();
    }
}