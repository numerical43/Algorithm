import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] stack;
	public static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		stack = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();

			switch (S) {
				case "push" :
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop" :
					sb.append(pop()).append("\n");
					break;
				case "size" :
					sb.append(size()).append("\n");
					break;
				case "empty" :
					sb.append(empty()).append("\n");
					break;
				case "top" :
					sb.append(top()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
	
	public static void push(int num) {
		stack[size] = num;
		size++;
	}

	public static int pop() {
		if (size == 0) 
			return -1;
		else {
			int p = stack[size - 1];
			size--;
			return p;
		}
	}

	public static int size() {
		return size;
	}

	public static int empty() {
		if (size == 0) 
			return 1;
		else return 0;
	}

	public static int top() {
		if (size == 0) 
			return -1;
		else {
			return stack[size - 1];
		}
	}
}