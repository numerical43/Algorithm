import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] A = new int[45];
        int[] B = new int[45];
        A[0] = 0;
        A[1] = 1;
        B[0] = 1;
        B[1] = 1;

        // 피보나치
        for (int i = 2; i < 45; i++) {
            A[i] = A[i - 2] + A[i - 1];
            B[i] = B[i - 2] + B[i - 1];
        }

        System.out.println(A[K - 1] + " " + B[K - 1]);
    }
}