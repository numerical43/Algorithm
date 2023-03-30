import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // HashSet 과 동일하게 중복 값을 허용하지 않고 동일한 구조를 가진다.
        // HashSet 과 다르게 삽입된 순서대로 반복된다.
        LinkedHashSet<String> hash = new LinkedHashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            String student = br.readLine();

            if (hash.contains(student))
                hash.remove(student);

            hash.add(student);
        }

        // Iterator(반복자) : 배열이나 리스트, 그와 유사한 자료구조의 내부요소를 순회하는 객체이다.
        // LinkedHashSet 은 index 를 이용하여 순회할 수 없기 때문에 Iterator 를 사용해야 한다.
        // 주로 ArrayList, HashSet 과 같은 컬렉션을 반복하는 데에 사용하고, for-each 문이 할 수 없는 일을 할 수 있다.
        Iterator<String> iter = hash.iterator();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (iter.hasNext())
                sb.append(iter.next()).append('\n');
        }

        System.out.print(sb);
    }
}