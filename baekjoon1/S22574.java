package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class S22574 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int j = 1; j<=n;j++) {
				sum+=j;
				if(sum==p) {
					sum -= 1;
				}
			}
			sb.append(sum+"\n");
		}
		System.out.print(sb.toString().trim());
	}
}
