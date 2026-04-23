import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int cnt = 0;
		
		int idx = 0;
		while(idx<n&&arr[idx]<k) {
			idx++;
		}
		
		cnt+=(n-idx);
		int left = 0;
		int right = idx-1;
		
		while(left<right) {
			if(arr[left]+arr[right]>=k) {
				cnt++;
				left++;
				right--;
			}
			else {
				left++;
			}
		}
		
		if(cnt==0) System.out.print(-1);
		else System.out.println(cnt);
	}
}
