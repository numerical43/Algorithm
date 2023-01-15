import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int stick = 64;

        while (x > 0) {
            if (stick > x)
                stick /= 2;
            else {
                count++;
                x -= stick;
            }
        }
        System.out.println(count);
    }
}