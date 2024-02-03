import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;
        
        while (st.hasMoreTokens())
            result += Long.parseLong(st.nextToken());
        
        System.out.print(result);
    }
}