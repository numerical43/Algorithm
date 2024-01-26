import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
		int result = str.charAt(0) == 'c' ? 26 : 10;
		
		for (int i = 1; i < str.length(); i++) {
            int num = str.charAt(i) == 'c' ? 26 : 10;
            
            if (str.charAt(i) == str.charAt(i - 1))
                num -= 1;
            
            result *= num;
		}
        
		System.out.println(result);
	}
}