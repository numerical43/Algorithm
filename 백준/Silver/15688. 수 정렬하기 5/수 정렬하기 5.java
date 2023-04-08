import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];
        
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(array);

        for (Integer num : array)
            sb.append(num).append('\n');

        System.out.print(sb);
    }
}