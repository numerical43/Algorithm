import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String[] array = new String[str.length()];

        for (int i = 0; i < str.length(); i++)
            array[i] = str.substring(i);

        Arrays.sort(array);

        for (String s : array)
            sb.append(s).append('\n');

        System.out.print(sb);
    }
}