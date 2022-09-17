import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n =  scanner.nextInt();
        int count = 1;
        int range = 2;

        if (n == 1){
            System.out.println(1);
        }
        else {
            while (range <= n){
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
    } 
}