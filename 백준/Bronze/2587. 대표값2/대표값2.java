import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        int sum = 0;
        
        for (int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
        }
        
        Arrays.sort(array);
        
        System.out.print((sum /5) + "\n" + array[2]);
    }
}