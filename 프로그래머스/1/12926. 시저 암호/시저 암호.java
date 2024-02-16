class Solution {
    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            
            if (now == ' ')
                sb.append(' ');
            else if ((now <= 'z' && now + n > 'z') || (now <= 'Z' && now + n > 'Z'))
                sb.append((char)(now + n - 26));
            else
                sb.append((char)(now + n));
        }
        
        return sb.toString();
    }
}