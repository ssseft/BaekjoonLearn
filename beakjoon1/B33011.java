package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B33011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int odd = 0;
			int even = 0;
			for(int j = 0; j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num%2==0) even++;
				else odd++;
			}
			if(odd==even) sb.append("heeda0528"+"\n");
			else {
				int max = Math.max(odd, even);
				if(max%2==1) {
					sb.append("amsminn"+"\n");
				}
				else {
					sb.append("heeda0528"+"\n");
				}
			}
		}
		System.out.println(sb.toString().trim());
	}
}