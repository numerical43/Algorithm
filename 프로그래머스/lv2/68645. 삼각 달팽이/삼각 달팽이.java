import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] array = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 	
                switch (i % 3) {
                    case 0: 
                        x++;
                        break;
                    case 1:
                        y++;
                        break;
                    case 2:
                        x--;
                        y--;
                        break;
                }
                array[x][y] = num++;
            }
        }
        
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 0) 
                	break;
                answer[k++] = array[i][j];
            }
        }

        return answer;
    }
}