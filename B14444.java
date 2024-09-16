package beakjun;
import java.util.Scanner;

public class B14444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		StringBuilder sb = new StringBuilder();
		sb.append('0');
		for(int i =0 ;i<S.length();i++) {
			sb.append(S.charAt(i)+"0");
		}		
		// baekjoon���� 'oo'ó�� ¦������ �Ӹ������ ����ϱ� ���� ���̿� 0 �ֱ�
		S = sb.toString();
		int[] dp = new int[S.length()]; // i�� �߽����� �ϴ� �Ӹ���� ������
		int r = 0,c =0; // r�� ~i���� ������ �Ӹ���� �ε��� �� ���� ū ��
					// c�� ~i���� ������ r�� �ִ��� �Ǵ� �߽��ε���
		for(int i =0; i<S.length();i++) {
			if(r<i) {	//���� ����ߴ��� �ƴ϶�� 0���� �ʱ�ȭ
				dp[i] = 0;
			}
			else {	//���� ����ߴ� �Ӹ���� �� �� ���ڶ�� i'�� r-i�� �ּڰ��� dp�� ����
					//��? r-i�� 
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