import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            
            if (now >= 'a' && now <= 'z') {
                if (now < 'n')
                    sb.append((char) (now + 13));
                else
                    sb.append((char) (now - 13));
            } 
            else if (now >= 'A' && now <= 'Z') {
                if (now < 'N')
                    sb.append((char) (now + 13));
                else
                    sb.append((char) (now - 13));
            }
            else
                sb.append(now);
        }

        System.out.println(sb);
    }
}