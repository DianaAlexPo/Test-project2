import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static void main(String[] args) throws Exception {
        //generation numbers and check prime numbers
        Random r = new Random();
        int[] numbers = new int[100];
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            numbers[i] = r.nextInt(1001);
            if(checkPrimeNumber(numbers[i])) primeNumbers.add(Integer.valueOf(numbers[i]));
        }

        //write random numbers
        String stringAllNumbers = Arrays.toString(numbers);
        stringAllNumbers = stringAllNumbers.substring(1, stringAllNumbers.length()-1).replaceAll(", ", " ");
        FileWriter nFile = new FileWriter("output.txt");
        nFile.write(stringAllNumbers+"\n");

        //Integer to int
        int[] primeNumbersInt =  new int[primeNumbers.size()];
        for(int i = 0; i < primeNumbers.size(); i++){
            primeNumbersInt[i] = (int) primeNumbers.get(i);
        }
        //write prime numbers
        String stringPrimeNumbers = Arrays.toString(primeNumbersInt);
        stringPrimeNumbers = stringPrimeNumbers.substring(1, stringPrimeNumbers.length()-1).replaceAll(", ", " ");
        nFile.write(stringPrimeNumbers);
        nFile.close();
    }

    public static boolean checkPrimeNumber(int num){
        if(num == 0 || num == 1) return false;
        for(int i = 2; i < (int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
