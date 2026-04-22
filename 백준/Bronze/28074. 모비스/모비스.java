import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		char[] arr = new char[]{'M','O','B','I','S'};
		boolean[] ch = new boolean[5];
		for(int i = 0;i<a.length();i++) {
			char c = a.charAt(i);
			for(int j = 0;j<5;j++) {
				if(arr[j]==c) {
					ch[j] = true;
				}
			}
		}
		for(int i = 0;i<5;i++) {
			if(!ch[i]) {
				System.out.print("NO");
				return;
			}
		}
		System.out.print("YES");
		
	}
}
