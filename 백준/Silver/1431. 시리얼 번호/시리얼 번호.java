import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = new String[n];

        for (int i = 0; i < n; i++)
            array[i] = br.readLine();

        // Comparator 인터페이스를 이용해서 sort
        // 두 수의 차 -> 음수, 0, 양수로 구분해서 크고 작음을 비교해서 정렬한다.
        Arrays.sort(array, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                if (sumStringNum(o1) == sumStringNum(o2))
                    // 앞에서부터 순서대로 아스키값을 비교해서 차이가 있다면 그 값을 반환한다. 
                    return o1.compareTo(o2);

                return sumStringNum(o1) - sumStringNum(o2);
            }
            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for (String str : array)
            sb.append(str).append('\n');

        System.out.print(sb);
    }

    public static int sumStringNum(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                result += str.charAt(i) - '0';
        }

        return result;
    }
}