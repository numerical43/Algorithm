import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 그룹의 단어 개수
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            // 알파벳 사용 내역 체크를 위한 배열
            boolean[] alphabets = new boolean[26];
            // 그룹 단어인지 체크하기위한 변수
            boolean check = true;

            for (int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'a';
                //이전에 사용한 적이 있는 문자일 경우
                if (alphabets[idx]) {
                    // 이전 문자와 겹치지않는 경우
                    if (str.charAt(j) != str.charAt(j - 1)) {
                        // 그룹 단어 X
                        check = false;
                        break;
                    }
                }
                //이전에 사용한 적이 없는 문자일 경우
                else {
                    alphabets[idx] = true;
                }
            }
            if (check)
                count++;
        }
        System.out.println(count);
    }
}