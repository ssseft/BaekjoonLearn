import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=  new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i  =0;i<n;i++) {
			String word = br.readLine();
			int bit = 0;
			for(int j = 0;j<word.length();j++) {
				char c = word.charAt(j);
				bit |= (1<<(c-'a'));
			}
			list.add(bit);
		}
		int bit = (1<<26)-1;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			char al = st.nextToken().charAt(0);
			if(f==1) {
				bit-=(1<<(al-'a'));
			}
			else {
				bit+=(1<<(al-'a'));
			}
			
			int cnt = 0;
			
			for(int j = 0;j<n;j++) {
				int sum = (list.get(j) | bit);
				if(sum==bit) cnt++;
			}
			
			sb.append(cnt+"\n");
		}
		System.out.print(sb.toString().trim());
	}
}