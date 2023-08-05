class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int oneIndex = 0;
        int twoIndex = 0;
        
        for (int i = 0; i < goal.length; i++) {
        	if (oneIndex < cards1.length && goal[i].equals(cards1[oneIndex]))
        		oneIndex++;
            else if (twoIndex < cards2.length && goal[i].equals(cards2[twoIndex]))
        		twoIndex++;
            else {
        		answer = "No";
        		break;
        	}
        }
        
        return answer;
    }
}