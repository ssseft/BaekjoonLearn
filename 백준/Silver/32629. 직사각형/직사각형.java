import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=  new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int a = (int)Math.sqrt(n);
			int min = Integer.MAX_VALUE;
			for(int i = a;i<=a+2;i++) {
				int h = (n+i-1)/i;
				int p = 2*(i+h);
				if(p<min) {
					min = p;
				}
			}
			sb.append(min+"\n");
		}
		System.out.print(sb);
	}
}
