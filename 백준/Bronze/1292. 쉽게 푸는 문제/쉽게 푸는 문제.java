import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] array = new int [b + 1];
        int index = 1;
        int result = 0;

        for (int i = 1; i <= b; i++) {
            for (int j = 0; j < i; j++) {
                if (index == b + 1)
                    break;

                array[index] = i;
                index++;
            }
        }

        for (int i = a; i <= b; i++)
            result += array[i];

        System.out.println(result);
    }
}