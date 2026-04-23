import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        
        m+=t;
        if(m>=60){
            int d = m/60;
            m %= 60;
            h+=d;
        }
        h%=24;
        System.out.print(h+" "+m);
    }
}

