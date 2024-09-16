package beakjun;
import java.util.Scanner;

public class B2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        int count = 0;
        
        while (n > 0) {
            if (n >= 5) {
                n -= 5;
                count++;
            } else if (n >= 3) {
                n -= 3;
                count++;
            } else {
                count = -1;
                break;
            }
        }
        
        if (count == -1) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}