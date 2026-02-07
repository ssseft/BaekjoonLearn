import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            if (n == Integer.parseInt(st.nextToken())) count++;
        }
        System.out.print(count);
    }
}