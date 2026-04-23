import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb=  new StringBuilder();
		for(int i =0 ;i<p;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			long n = Integer.parseInt(st.nextToken());
			sb.append(num+" "+pisano(n)+"\n");
		}
		System.out.print(sb.toString().trim());
		
	}
	static long pisano(long n) {
		long pre = 0;
		long cur = 1;
		long tmp = 0;
		
		for(long i = 0;i<500000;i++) {
			tmp = (pre+cur)%n;
			pre = cur;
			cur = tmp;
			
			if(pre==0&&cur==1) {
				return i+1;
			}
		}
		return 0;
	}
}
