import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		boolean[] c = new boolean[b+1];
		
		for(int i = 1; i<=Math.sqrt(b); i++) {
			c[i*i] = true;
		}
		int sum = 0;
		int d = 0;
		for(int j = a; j<=b; j++){
			if(c[j]) {
				sum += j;
				if(d==0) {
					d=j;
				}
			}
		}
		if(d==0){
			System.out.println("-1");
		}
		else{
			System.out.println(sum);
			System.out.println(d);
		}
	}
}