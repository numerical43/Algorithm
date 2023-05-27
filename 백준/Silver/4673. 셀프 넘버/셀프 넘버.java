public class Main {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int sum = i;
            int temp = i;

            while (temp != 0) {
                sum = sum + (temp % 10);
                temp /= 10;
            }

            // 10000보다 작을 경우만 true 로 바꿔준다.
            if (sum < 10001)
                check[sum] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            if (!check[i])
                sb.append(i).append('\n');
        }

        System.out.print(sb);
    }
}