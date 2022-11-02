import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        int max = -1;
        char result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (('a' <= str.charAt(i)) && ('z' >= str.charAt(i)))
                arr[str.charAt(i) - 'a']++;

            else if (('A' <= str.charAt(i)) && ('Z' >= str.charAt(i)))
                arr[str.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = (char)(i + 'A'); // 대문자로 출력하기 위해
            }
            else if (arr[i] == max)
                result = '?';
        }
        System.out.println(result);
    }
}