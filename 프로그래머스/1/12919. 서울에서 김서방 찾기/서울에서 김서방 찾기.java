class Solution {
    public String solution(String[] seoul) {
        int count = 0;
        
        while (true) {
            if (seoul[count].equals("Kim"))
                break;
            else
                count++;
        }
        
        return "김서방은 " + count + "에 있다";
    }
}