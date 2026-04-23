import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int numInt = sc.nextInt();
			String num = Integer.toString(numInt);
			if(numInt == 0) {
				sc.close();
				break;
			}
			boolean A = true;
			
			for(int i =0; i<num.length()/2;i++) {
				if(num.charAt(i) != num.charAt(num.length()-1-i)) {
					A = false;
					break;
				}
			}
			if(A == true) {
				System.out.println("yes");
			}
			else
				System.out.println("no");
		}
	}
}