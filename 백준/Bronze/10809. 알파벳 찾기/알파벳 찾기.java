import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] c = new int[26];
		
		for(int i =0;i<26;i++) {
			c[i] = -1;
		}
		
		String d = sc.next();
		sc.close();
		
		for(int j = 0; j<d.length();j++) {
			char e = d.charAt(j);
			
			if(c[e-97]== -1) {
			c[e-97] =j;
			}
		}
		for(int f : c)
		System.out.print(f + " ");
	}
}