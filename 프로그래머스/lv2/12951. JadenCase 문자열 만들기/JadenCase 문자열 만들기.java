class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] temp = s.toLowerCase().split("");
        boolean flag = true;

        for (String now : temp) {
            answer.append(flag ? now.toUpperCase() : now);
            flag = now.equals(" ") ? true : false;
        }
        
        return answer.toString();
    }
}