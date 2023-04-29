import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++)
            heap.offer(scoville[i]);
        
        while(heap.peek() < K) {
            if (heap.size() < 2)
                return -1;
            
            int h1 = heap.poll();
            int h2 = heap.poll();
            
            int sum = h1 + (h2 * 2);
            heap.offer(sum);
            answer++;
        }
        
        return answer;
    }
}