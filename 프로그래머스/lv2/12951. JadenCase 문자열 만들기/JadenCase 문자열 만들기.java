import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Solution {
    public String solution(String s) {
        List<String> list = new ArrayList<>();
        boolean flag = false;

        // 소문자로 전부 list 에 저장
        for (int i = 0; i < s.length(); i++)
            list.add(String.valueOf(s.charAt(i)).toLowerCase(Locale.ROOT));

        for (int i = 0; i < s.length(); i++) {
            // 한 단어의 첫 문자가 아닌 문자들 건너뛰기
            if (flag && !list.get(i).equals(" "))
                continue;
                // 공백이라면 flag 초기화
            else if (list.get(i).equals(" ")) {
                flag = false;
                continue;
            }

            // 단어의 첫 문자 대문자로 넣고 flag = true 로
            list.set(i, list.get(i).toUpperCase());
            flag = true;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : list)
            sb.append(value);

        return sb.toString();
    }
}