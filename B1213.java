package beakjun;
import java.util.Scanner;

public class B1213 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		sc.close();
		int[] ab = new int[26];
		
		for(char sp : word.toCharArray()) {
			ab[sp-65]++;
		}
		
		int count = 0; //¾ËÆÄºª È¦¼ö °¹¼ö
		int mid = 0;// Áß¾Ó°ª
		for(int i = 0; i<26; i++) {
			if(ab[i]%2 ==1) {
				count++;
				mid = i;
			}
		}
		if((word.length() % 2 == 1 && count!=1)||(word.length()%2 == 0 && count!=0)){
			System.out.print("I'm Sorry Hansoo");
		}
		else {
			String front = "";
			String back = "";
			for(int i =0; i<26; i++) {
				for(int j=0; j<ab[i]/2;j++) {
					front += (char)(i+65);
					back += (char)(i+65);
				}
			}
			if(word.length()%2 != 0){
				front += (char)(mid+65);
			}
			
			for(int i = 0;i<back.length();i++) {
				front += back.charAt(back.length()-1-i);
			}
			System.out.print(front);
			
		}
	}
}