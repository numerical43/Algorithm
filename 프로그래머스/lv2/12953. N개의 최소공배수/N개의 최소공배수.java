class Solution {
    // 유클리드 호제법 (재귀 함수)
    public static int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        else
            return gcd(num2, num1 % num2);
    }

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int num = gcd(answer, arr[i]);
            answer = answer * arr[i] / num;
        }

        return answer;
    }
}