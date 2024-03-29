import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[] str = new String[5];
    static StringBuilder line = new StringBuilder();
    static StringBuilder answer = new StringBuilder();

    public static void recursive(int m){
        if (m == 0) {
            answer.append(line).append(str[0])
                    .append(line).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
                    .append(line).append(str[4]);
            return;
        }

        for (int i = 0; i < 4; i++)
            answer.append(line).append(str[i]);

        // 언더바 추가
        line.append("____");

        recursive(m - 1);

        // 언더바 삭제
        line.delete(0, 4);
        answer.append(line).append(str[4]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        str[0] = "\"재귀함수가 뭔가요?\"\n";
        str[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        str[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        str[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        str[4] = "라고 답변하였지.\n";

        answer.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursive(n);

        System.out.println(answer);
    }
}