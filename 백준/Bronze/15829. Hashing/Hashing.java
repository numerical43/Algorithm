import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] array = str.toCharArray();
        long result = 0;
        long r = 1;
        int m = 1234567891;

        for (int i = 0; i < l; i++) {
            result += ((array[i]  - 96) * r) % m;
            r = (r * 31) % m;
        }
        result %= m;
        System.out.println(result);
    }
}