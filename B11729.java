package beakjun;
import java.util.Scanner;

public class B11729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int n = sc.nextInt();
        sc.close();
        output.append(poweroftwo(n) - 1).append("\n");
        hanoi(n, 1, 2, 3, output);
        System.out.print(output);
    }

    public static void hanoi(int n, int fr, int tem, int to, StringBuilder output) {
        if (n == 1) {
            output.append(fr).append(" ").append(to).append("\n");
            return;
        } else {
            hanoi(n - 1, fr, to, tem, output);
            output.append(fr).append(" ").append(to).append("\n");
            hanoi(n - 1, tem, fr, to, output);
        }
    }

    public static int poweroftwo(int n) {
        if (n == 0) {
            return 1;
        } else {
            return 2 * poweroftwo(n - 1);
        }
    }
}