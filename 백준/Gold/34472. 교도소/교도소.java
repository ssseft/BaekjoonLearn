import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[n];
		long total = 0;
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		
		long quo = total/n;
		long cnt = 0;
		long ans = 0;
		for(int i = 0;i<2*n;i++) {
			if(quo<arr[i%n]) {
				cnt += (arr[i%n]-quo);
				arr[i%n] = quo;
			}
			else {
				if(cnt>quo-arr[i%n]) {
					cnt -= quo-arr[i%n];
					arr[i%n] = quo;
				}
				else {
					arr[i%n] += cnt;
					cnt = 0;
				}
			}
			ans += cnt;
		}
		System.out.print(ans);
	}
}