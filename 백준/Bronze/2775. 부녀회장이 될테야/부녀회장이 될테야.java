import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];
        
        for (int i = 0; i < 15; i++)
            apt[0][i] = i;
        
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++)
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
        }
        
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append('\n');
        }
        
        System.out.println(sb);
    }
}