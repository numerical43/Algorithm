class Solution {
    static int answer = 0;

    public void DFS(int[] numbers, int depth, int target, int sum) {
        // 현재 깊이가 마지막 노드라면
        if (depth == numbers.length) {
            if (target == sum)
                answer++;
        }
        else {
            DFS(numbers, depth + 1, target, sum + numbers[depth]);
            DFS(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

    public int solution(int[] numbers, int target) {
        DFS(numbers, 0, target, 0);

        return answer;
    }
}
