import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(b>=c)  System.out.println(-1);
		else {
            long cnt = 1;
            while(true){
                if(a+b*cnt<c*cnt) break;
                cnt++;
            }
            System.out.print(cnt);
        }
		
	}
}
