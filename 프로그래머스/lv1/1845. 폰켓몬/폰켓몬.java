import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int max = nums.length / 2;
        
        HashSet<Integer> hash = new HashSet<>();
        
        for (int num : nums)
            hash.add(num);
        
        if (hash.size() > max)
            answer = max;
        else
            answer = hash.size();
        
    
        return answer;
    }
}