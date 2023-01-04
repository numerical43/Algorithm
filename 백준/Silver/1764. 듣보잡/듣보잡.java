import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(br.readLine());

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();

            if (set.contains(temp))
                result.add(temp);
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result)
            sb.append(s).append("\n");

        System.out.print(sb);
    }
}