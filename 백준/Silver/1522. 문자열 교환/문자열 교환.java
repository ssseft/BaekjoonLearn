import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		sc.close();
		
		int[] arr = new int[word.length()];
		if(word.charAt(0)=='a') arr[0]++;
		for(int i= 1;i<word.length();i++) {
			arr[i] = arr[i-1];
			if(word.charAt(i)=='a') arr[i]++;
		}
		int Acnt = arr[word.length()-1];
		if(word.length()<=1||Acnt==0) {
			System.out.print(0);
			return;
		}
		int max = arr[Acnt-1];
		
		//일직선 원형 고려x
		for(int i = Acnt;i<word.length();i++) {
			int cnt = arr[i]-arr[i-Acnt];
			max = Math.max(cnt, max);
		}
		//원형
		for(int i = word.length()-Acnt+1;i<word.length();i++) {
			int cnt = Acnt-arr[i-1]+arr[(i+Acnt-1)%word.length()];
			max = Math.max(cnt, max);
		}
		System.out.print(Acnt-max);
	}
}