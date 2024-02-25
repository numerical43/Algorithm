import java.util.*;

public class Solution {
	public int[] solution(int k, int[] score) {
        int length = score.length;
		int[] answer = new int[score.length];
		ArrayList<Integer> rank = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			rank.add(score[i]);
            
			if (i >= k) 
                rank.remove(Collections.min(rank));
            
			answer[i] = Collections.min(rank);
		}
        
		return answer;
	}
}