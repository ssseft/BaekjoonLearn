package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18185_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] s2 = new int[n];
		int cost = 0;
		
		for(int i = 0;i<n-1;i++) {
			if(arr[i]>=arr[i+1]) {
				arr[i]-=arr[i+1];
				s2[i] += arr[i+1];
				cost+= arr[i]*3 + arr[i+1]*5;
				arr[i+1] = 0;
				arr[i] = 0;//필요없는듯
			}
			else {
				s2[i] = arr[i];
				cost += arr[i]*5;
				arr[i+1] -= arr[i];
				arr[i] = 0; //필요없는듯
				if(i>0&&s2[i-1]>0) {
					if(s2[i-1]>=arr[i+1]) {
						s2[i-1] -= arr[i+1];
						cost+= 2*arr[i+1];
						arr[i+1] = 0;
					}
					else {
						arr[i+1] -= s2[i-1];
						cost += s2[i-1]*2;
						s2[i-1] = 0;
					}
				}
			}
		}
		cost += arr[n-1]*3;
		
		System.out.print(cost);
	}
}
