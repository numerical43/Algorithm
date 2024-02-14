class Solution {
    public boolean solution(String s) {
        int length = s.length();
        
        if (length == 4 || length == 6)
            return s.matches("(^[\\d]*$)");
        
        return false;
    }
}