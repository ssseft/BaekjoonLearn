package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n+1];
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[0] = -1;
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(s==1) {
				int a = 1;
				while(true) {
					if(num*a>n) break;
					arr[num*a] = (arr[num*a]+1)%2;
					a++;
				}
			}
			else {
				int a =0;
				while(true) {
					if(num-a<0||num+a>n||arr[num-a]!=arr[num+a]) break;
					a++;
				}
				a--;
				for(int i = num-a;i<=num+a;i++) {
					arr[i] = (arr[i]+1)%2;
				}
			}
		}
		for(int i =1;i<=n;i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}
}
