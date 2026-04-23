import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		
		int[] b = new int[26];
		
		for(int i=0; i<a.length();i++) {
			if('A'<= a.charAt(i)&&a.charAt(i)<= 'Z') {
				b[a.charAt(i)- 'A']++;
			
			}
			else {
				b[a.charAt(i)- 'a']++;
			}
		}
		
	int max = -1;
	char c = '?';
	
	for (int i = 0; i<26; i++) {
		if(b[i]>max) {
			max = b[i];
			c = (char)(i+65);
			
		}
		else if (b[i] == max) {
			c = '?';
		}
	}
	System.out.println(c);
	sc.close();
	}
}