package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B33997 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[][] arr = new long[n][m];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		
		long[] left = new long[m];
		long[] right = new long[m];
		int[] leftidx = new int[m];
		int[] rightidx = new int[m];
		
		left[0] = arr[0][0];
		leftidx[0] = 0;
		right[m-1] = arr[0][m-1];
		rightidx[m-1] = m-1;
		
		for(int i = 1;i<m;i++) {
			long sum = left[i-1]+arr[0][i];
			if(sum>=arr[0][i]) {
				left[i] = sum;
				leftidx[i] = leftidx[i-1];
			}
			else {
				left[i] = arr[0][i];
				leftidx[i] = i;
			}
		}
		
		for(int i = m-2;i>=0;i--) {
			long sum = right[i+1]+arr[0][i];
			if(sum>=arr[0][i]) {
				right[i] = sum;
				rightidx[i] = rightidx[i+1];
			}
			else {
				right[i] = arr[0][i];
				rightidx[i] = i;
			}
		}
		long[] predp = new long[m];
		long[] curdp = new long[m];
		for(int i= 0;i<m;i++) {
			predp[i] = left[i]+right[i]-arr[0][i];
		}
		
		for(int i = 1;i<n;i++) {
			left = new long[m];
			right = new long[m];
			leftidx = new int[m];
			rightidx =new int[m];
			
			left[0] = arr[i][0];
			leftidx[0] = 0;
			right[m-1] = arr[i][m-1];
			rightidx[m-1] = m-1;
			
			for(int j = 1;j<m;j++) {
				long sum = left[j-1]+arr[i][j];
				if(sum>=arr[i][j]) {
					left[j] = sum;
					leftidx[j] = leftidx[j-1];
				}
				else {
					left[j] = arr[i][j];
					leftidx[j] = j;
				}
			}
			
			for(int j = m-2;j>=0;j--) {
				long sum = right[j+1] + arr[i][j];
				if(sum>=arr[i][j]) {
					right[j] = sum;
					rightidx[j] = rightidx[j+1];
				}
				else {
					right[j] = arr[i][j];
					rightidx[j] = j;
				}
			}
			long[] temp = new long[m];
			for(int j = 0;j<m;j++) {
				temp[j] = left[j]+right[j]-arr[i][j];
			}
			
			Deque<Integer> dq = new ArrayDeque<>();
			int prer = -1;
			
			for(int j = 0;j<m;j++) {
				for(int k = prer+1;k<=rightidx[j];k++) {
					while(!dq.isEmpty()&&predp[dq.peekLast()]<=predp[k]) {
						dq.pollLast();
					}
					dq.addLast(k);
				}
				while(!dq.isEmpty()&&dq.peekFirst()<leftidx[j]) {
					dq.pollFirst();
				}
				curdp[j] = temp[j]+predp[dq.peekFirst()];
				prer = Math.max(prer, rightidx[j]);
			}
			
			long[] t = predp;
			predp = curdp;
			curdp = t;
		}
		
		long max =  predp[0];
		for(int i = 0;i<m;i++) {
			max=  Math.max(max, predp[i]);
		}
		System.out.print(max);
	}
}
