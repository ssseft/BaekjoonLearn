import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[n-1];
		
		while(left<=right) {
			int mid = (left+right)/2;
			int[] quo = new int[(arr[n-1]-1)/mid+2];
			for(int i = 0;i<n;i++) {
				quo[(arr[i]-1)/mid+1]++;
			}
			if(!cal(quo)) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
			
		}
		
		System.out.print(left);
	}
	static boolean cal(int[] quo) {
		quo[1]--;
		
		for(int i = 3;i<quo.length;i++) {
			quo[1] -= quo[i]*(i-2);
		}
		
		if(quo[1]<0) {
			return false;
		}
		else {
			return true;
		}
	}
}
