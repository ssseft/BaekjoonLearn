package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9082 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			
			String line = br.readLine();
			String line2 = br.readLine();
			int[] num = new int[n];
			char[] mine = new char[n];
			for(int i = 0;i<n;i++) {
				num[i] = line.charAt(i)-'0';
				mine[i] = line2.charAt(i);
			}
			
			int result = 0;
			
			for(int i = 0;i<n;i++) {
				if(mine[i]=='*') {
					result++;
					for(int j = -1;j<2;j++) {
						if(i+j>=0&&i+j<n) {
							num[i+j]--;
						}
					}
				}
			}
			
			if(num[0]>0&&num[1]>0) {
				result++;
				num[0]--;
				num[1]--;
			}
			
			for(int i = 1;i<n-1;i++) {
				int cnt = 0;
				for(int j = -1;j<2;j++) {
					if(num[i+j]>0) cnt++;
				}
				if(cnt==3) {
					result++;
					for(int j = -1;j<2;j++) {
						num[i+j]--;
					}
				}
			}
			
			if(num[n-1]==1&&num[n-2]==1) {
				result++;
			}
			
			sb.append(result+"\n");
		}
		System.out.print(sb.toString().trim());
	}
	
}
