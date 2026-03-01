import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		long cnt = 0;
		for(int i = 0;i<n-2;i++) {
			int left = i+1;
			int right = n-1;
			int c = arr[i];
			while(left<right) {
				int sum = c+arr[left]+arr[right];
				if(sum==0) {
					if(arr[left]==arr[right]) {
                        long m = right-left+1;
                        cnt += m*(m-1)/2;
                        break;
                    }
					int leftcnt = 0;
					int rightcnt = 0;
					int lv = arr[left];
                    int rv = arr[right];
					while(left<right&&arr[left]==lv) {
						left++;
						leftcnt++;
					}
					while(left<=right&&arr[right]==rv) {
						right--;
						rightcnt++;
					}
					cnt += leftcnt*rightcnt;
				}
				else if(sum>0) {
					right--;
				}
				else {
					left++;
				}
				
			}	
		}
		System.out.print(cnt);
	}
}
