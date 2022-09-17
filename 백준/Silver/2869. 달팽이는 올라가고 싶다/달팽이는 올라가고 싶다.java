import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] abv = br.readLine().split(" ");

        int a = Integer.parseInt(abv[0]);
        int b = Integer.parseInt(abv[1]);
        int v = Integer.parseInt(abv[2]);

        int day = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) {
            day++;
        }
        
        System.out.println(day);
    } 
}