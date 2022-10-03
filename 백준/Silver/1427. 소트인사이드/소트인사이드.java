import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(str.charAt(i));
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i = 1; i < n; i++) {
            arr[0] += arr[i];
        }
        System.out.println(arr[0]);
    }
}