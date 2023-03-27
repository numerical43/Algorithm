import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int n = Integer.parseInt(st.nextToken());
        Integer[] array = new Integer[n];
        
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(array, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer num : array)
            sb.append(num).append('\n');

        System.out.print(sb);
    }
}