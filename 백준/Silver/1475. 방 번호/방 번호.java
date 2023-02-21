import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int max = 0;

        // 사용되는 수가 0 ~ 9이므로 해당 수를 index로 사용한다. 
        // arr 의 해당 index 값을 증가시킨다. 이렇게하면 해당 숫자가 몇 번 필요한지 알수있다.
        // 주어지는 수가 공백없는 하나의 자연수이기 떄문에 나머지로 현재 숫자를 확인하고, 몫을 다시 저장한다.
        while (num > 0) {
            arr[num % 10]++;
            num /= 10;
        }

        // 6과 9는 혼용해서 사용할 수 있기 떄문에 더한 뒤 2로 나눈다. 홀수이면 +1 한다. 
        // arr[6]에 계산한 값을 넣어주고, 밑에서 max 세트 수를 찾을 때 0 ~ 8까지만 돌도록 한다.
        int temp = arr[6] + arr[9];
        arr[6] = (temp % 2 != 0) ? temp / 2 + 1 : temp / 2;

        for (int i = 0; i < 9; i++)
            max = Math.max(arr[i], max);

        System.out.println(max);
    }
}
