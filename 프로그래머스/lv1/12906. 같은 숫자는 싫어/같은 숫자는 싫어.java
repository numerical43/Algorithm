import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();


        int temp = -1;
        for (int num : arr) {
            if (num != temp) {
                answer.add(num);
                temp = num;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}