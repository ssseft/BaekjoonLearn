package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B22862 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int max = 0;
		int lastoddidx = -1;
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1;i<=n;i++) {
			int c = Integer.parseInt(st.nextToken());
			
			if(c%2==1) {
				list.add(i);
				if(cnt<k) cnt++;
				else lastoddidx++;
			}
			
			if(!list.isEmpty()&&lastoddidx>=0) max = Math.max(max, i-list.get(lastoddidx)-cnt);
			else max = Math.max(max, i-cnt);
		}
		System.out.print(max);
		
	}
}
