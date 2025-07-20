package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S22039 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n%3==1) {
				
				sb.append("impossible");
			}
			else {
				if(n%3==2) {
					sb.append("BA");
				}
				for(int j = 0; j<n/3;j++) {
					sb.append("BBA");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}