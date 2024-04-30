import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < length; i++) {
            for(int j = (i + 1); j < length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}