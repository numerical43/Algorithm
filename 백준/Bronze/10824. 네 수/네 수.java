import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        String ab = str[0] + str[1];
        String cd = str[2] + str[3];
        
        long answer = Long.parseLong(ab) + Long.parseLong(cd);
        
        System.out.println(answer);
    }
}