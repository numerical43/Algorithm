import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] ca = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		for (String s : ca) {
			str = str.replace(s, "1");
		}
		
		System.out.println(str.length());
	}
}