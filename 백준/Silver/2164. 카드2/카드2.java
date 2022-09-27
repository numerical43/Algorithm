import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (queue.size() != 1) {
			//큐가 비었을 때 remove 하면 예외 발생, poll 하면 null 반환
			queue.poll();
			//값 추가에 실패하면 offer 는 예외 발생, offer 는  false 반환 (성공은 둘 다 true)
			queue.offer(queue.poll());
		}

		System.out.println(queue.poll());
	}
}