import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        int [] arr = new int[n];
        for(int i = 0; i< n; i++)
            arr[i] = Integer.parseInt(bf.readLine());
        
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int num : arr)
            sb.append(num).append("\n");
        
        System.out.print(sb);
    }
}