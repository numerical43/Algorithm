import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Solution {
    public String solution(String s) {
        String answer;
        List<String> list = new ArrayList<>();
        boolean flag = true;

        for (int i = 0; i < s.length(); i++)
            list.add(String.valueOf(s.charAt(i)).toLowerCase(Locale.ROOT));

        list.set(0, list.get(0).toUpperCase(Locale.ROOT));

        for (int i = 0; i < s.length(); i++) {
            if (flag && !list.get(i).equals(" "))
                continue;
            else if (list.get(i).equals(" ")) {
                flag = false;
                continue;
            }

            if (!flag && list.get(i - 1).equals(" ")) {
                list.set(i, list.get(i).toUpperCase(Locale.ROOT));
                flag = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String value : list)
            sb.append(value);

        answer = sb.toString();

        return answer;
    }
}