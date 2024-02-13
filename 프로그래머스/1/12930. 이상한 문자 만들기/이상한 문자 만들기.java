class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        s.toLowerCase();
        
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                index = 0;
                answer += " ";
            }
            else {
                if (index++ % 2 == 0)
                    answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
                else
                    answer += String.valueOf(Character.toLowerCase(s.charAt(i)));
            }
        }
        
        return answer;
    }
}