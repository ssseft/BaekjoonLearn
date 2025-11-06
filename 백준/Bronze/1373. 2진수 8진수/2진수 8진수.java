import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        StringBuilder sb = new StringBuilder(n);
        int remainder = n.length()%3;
        sb.reverse();
        if(remainder!=0) {
        	for(int i = 0;i<3-remainder;i++) {
                sb.append("0");
            }
        }
        sb.reverse();
        String a = sb.toString();
        sb = new StringBuilder();
        for(int i = 0;i<(n.length()-1)/3+1;i++) {
            int sum = 0;
            for(int j = 0;j<3;j++) {
                if(a.charAt(i*3+j)=='1') {
                    sum+=Math.pow(2, 2-j);
                }
            }
            sb.append(sum);
        }
        System.out.print(sb);
    }
}