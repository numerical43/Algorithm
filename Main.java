import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toLowerCase(Locale.ROOT);
        int result = 0;

        char find = (char) br.read();
        find = Character.toLowerCase(find);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == find)
                result++;
        }

        System.out.println(result);
    }
}