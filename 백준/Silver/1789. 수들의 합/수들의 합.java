import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 0;

        for (int i = 1; sum <= num; i++) {
            sum += i;
            count++;
        }

        System.out.println(count - 1);
    }

}