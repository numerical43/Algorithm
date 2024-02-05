import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        long[] array = new long[68];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;
        
        for (int i = 4; i <= 67; i++)
            array[i] = array[i - 1] + array[i - 2] + array[i - 3] + array[i - 4];
            
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(array[n] + "\n");
        }
        
        System.out.print(sb);
    }
}