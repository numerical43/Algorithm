import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] array = new String[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            array[i][0] = st.nextToken();
            array[i][1] = st.nextToken();
        }
        
        Arrays.sort(array, Comparator.comparingInt(s -> Integer.parseInt(s[0])));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(array[i][0]).append(' ').append(array[i][1]).append('\n');

        System.out.println(sb);
    }
}