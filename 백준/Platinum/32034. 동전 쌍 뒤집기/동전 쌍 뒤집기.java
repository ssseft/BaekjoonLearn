import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int score;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		Stack<Integer> odd;
		Stack<Integer> even;
		
		for(int i = 0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			String coin = br.readLine();
			score = 0;
			odd = new Stack<>();
			even = new Stack<>();
			for(int j= 0;j<n;j++) {
				char c = coin.charAt(j);
				if(c=='T') {
					if(j%2==1) {
						odd.add(j);
					}
					else {
						even.add(j);
					}
				}
			}
			if(odd.size()==even.size()) {
				long cnt = 0;
				while(!odd.isEmpty()){
					int a = odd.pop();
					int b = even.pop();
					cnt+=Math.abs(a-b);
				}
				sb.append(cnt+"\n");
			}
			else {
				sb.append(-1+"\n");
			}
		}
		System.out.print(sb.toString().trim());
	}
}