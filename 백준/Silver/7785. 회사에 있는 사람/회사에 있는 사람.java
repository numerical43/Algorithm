import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String state = st.nextToken();

            // 이름이 이미 존재하면 먼저 삭제한다.
            if (hashMap.containsKey(name))
                hashMap.remove(name);
            else
                hashMap.put(name, state);
        }

        StringBuilder sb = new StringBuilder();
        // hashMap 의 모든 key 를 ArrayList 로 변환한 뒤 알파벳 정렬한다.
        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());
        arrayList.sort(Collections.reverseOrder());

        // ArrayList 를 String Builder 에 다시 저장한다.
        for (String str : arrayList)
            sb.append(str).append('\n');

        System.out.print(sb);
    }
}