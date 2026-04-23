import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[k][3];
		
		for(int i=  0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int left = 0;
		int right = n;
		
		while(left<=right) {
			int mid = (left+right)/2;
			long total = 0;
			for(int i = 0;i<k;i++) {
				int a = arr[i][0];
				int b = arr[i][1];
				int c = arr[i][2];
				if(mid>b) {
					total += (b-a)/c+1;
				}
				else if(a<=mid&&mid<=b) {
					total += (mid-a)/c+1;
				}
			}
			if(total>=d) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		System.out.println(left);
	}
}