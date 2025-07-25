package beakjoon1;
import java.util.Scanner;

public class B2720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		for(int i = 0; i<n;i++) {
			int money = sc.nextInt();
			if(money/25>=1) {
				sb.append(money/25+" ");
				money %= 25;
			}
			else {
				sb.append(0+" ");
			}
			
			if(money/10>=1) {
				sb.append(money/10+" ");
				money %= 10;
			}
			else {
				sb.append(0+" ");
			}
			
			if(money/5>=1) {
				sb.append(money/5+" ");
				money %= 5;
			}
			else {
				sb.append(0+" ");
			}
			
			if(money>=1) {
				sb.append(money+" ");
			}
			else {
				sb.append(0+" ");
			}
			sb.append("\n");
		}
		sc.close();
		System.out.print(sb.toString());
	}
}
