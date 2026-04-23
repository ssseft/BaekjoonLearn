import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		StringBuilder sb = new StringBuilder();
		sb.append('0');
		for(int i =0 ;i<S.length();i++) {
			sb.append(S.charAt(i)+"0");
		}		
		// baekjoon에서 'oo'처럼 짝수개의 팰린드롬을 계산하기 위한 사이에 0 넣기
		S = sb.toString();
		int[] dp = new int[S.length()]; // i를 중심으로 하는 팰린드롬 반지름
		int r = 0,c =0; // r은 ~i이전 까지의 팰린드롬 인덱스 중 가장 큰 값
					// c는 ~i이전 까지의 r의 최댓값이 되는 중심인덱스
		for(int i =0; i<S.length();i++) {
			if(r<i) {	//전에 계산했던게 아니라면 0으로 초기화
				dp[i] = 0;
			}
			else {	//전에 계산했던 팰린드롬 수 내 숫자라면 i'와 r-i중 최솟값을 dp에 저장
				dp[i] = Math.min(dp[2*c-i],r-i);
			}
			while(i-dp[i]-1>=0&& i+dp[i]+1<S.length()&&S.charAt(i-dp[i]-1)==S.charAt(i+dp[i]+1)) {
				dp[i]++;
			}
			if(r<i+dp[i]) {
				c = i;
				r = i+dp[i];
			}
		}
		
		
		
		
		int result = 0;
		for(int i =0; i<S.length();i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.print(result);
		
		
	}
}
