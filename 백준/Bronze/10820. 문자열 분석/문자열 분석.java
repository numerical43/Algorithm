import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";

        while ((str = br.readLine()) != null) {
            int[] answer = new int[4];

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    answer[0] += 1;
                else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                    answer[1] += 1;
                else if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                    answer[2] += 1;
                else if (str.charAt(i) == ' ')
                    answer[3] += 1;
            }

            for (int i = 0; i <= 3; i++)
                sb.append(answer[i]).append(' ');

            sb.append('\n');
        }

        System.out.print(sb);
    }
}