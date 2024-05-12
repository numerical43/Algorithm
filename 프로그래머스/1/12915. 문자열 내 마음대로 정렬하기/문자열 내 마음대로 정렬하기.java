import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int length = strings.length;
        String[] answer = new String[length];
        List<String> array = new ArrayList<>();
        
        for (int i = 0; i < length; i++) 
            array.add("" + strings[i].charAt(n) + strings[i]);
        
        Collections.sort(array);
        
        for (int i = 0; i < length; i++)
            answer[i] = array.get(i).substring(1, array.get(i).length());
        
        return answer;
    }
}