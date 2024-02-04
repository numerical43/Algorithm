import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int sum = 0;

		char[] array = str.toCharArray();
		Arrays.sort(array);

		for (int i = array.length - 1; i >= 0; i--) {
			int num = array[i] - '0';
			sum += num;
            
			sb.append(num);
		}
				
		if (array[0] != '0' || sum % 3 != 0)
			System.out.println(-1);
        else 
		    System.out.println(sb.toString());
        
	}
}