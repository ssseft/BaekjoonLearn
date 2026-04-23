import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int sum = 0;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			sum += price*cnt;
		}
		if(x==sum) {
			System.out.print("Yes");
		}
		else {
			System.out.print("No");
		}
	}
}
