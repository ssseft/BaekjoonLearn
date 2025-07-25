package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17383 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[n-1];
		
		
		while(left<right) {
			int mid = (left+right)/2;
			int[] num = new int[arr[n-1]/mid+2];
			for(int i = 0;i<n;i++) {
				num[(arr[i]-1)/mid+1]++;
			}
			
			if(check(num,n)) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		
		System.out.print(left);
		
		
		
	}
	static boolean check(int[] num, int n) {
	    int[] numCopy = Arrays.copyOf(num, num.length);
	    int a1 = 0, a2 = 0;
	    int cnt = 0;

	    for (int i = 1; i < numCopy.length && cnt < n; i++) {
	        while (numCopy[i] > 0) {
	            if (cnt < n) {
	                if (a1 <= cnt) {
	                    a1 += i;
	                    cnt++;
	                    numCopy[i]--;
	                } else if (a2 <= cnt) {
	                    a2 += i;
	                    cnt++;
	                    numCopy[i]--;
	                } else {
	                    return false;
	                }
	            }
	        }
	    }

	    return cnt >= n;
	}


}