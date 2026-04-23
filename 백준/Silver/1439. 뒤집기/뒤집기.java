import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append(sc.next());
		sc.close();
		int count = 0;
		int check = sb.charAt(0);
		for(int i = 1; i<sb.length(); i++) {
			int el = sb.charAt(i);
			if(check != el) {
				count++;
				check = el;
			}
		}
		int result = 0;
		if(count%2 == 0){
			result = count/2;
		}
		else {
			result = count/2+1;
		}
		System.out.print(result);
	}
}