import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1;i<=t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			List<Integer>[] list = new ArrayList[n+1];
			for(int j = 1;j<=n;j++) 
				list[j] = new ArrayList<>();
			
			for(int j = 0;j<m;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			int[] color = new int[n+1];
            Arrays.fill(color, -1);
			
			Queue<Integer> q = new ArrayDeque<>();
			boolean ch = false;
			for(int j = 1;j<=n;j++) {
				if(color[j]!=-1) continue;
				q.clear();
				color[j] = 0;
				q.add(j);
				while (!q.isEmpty()&&!ch) {
                    int cur = q.poll();
                    for(int nxt : list[cur]) {
                        if(color[nxt] == -1) {
                        	color[nxt] = (color[cur]+1)%2;
                        	q.add(nxt);
                        }
                        else if (color[nxt]==color[cur]){
                        	ch = true;
                        	break;
                        }
                    }
                }
				
			}
			sb.append("Scenario #"+i+":\n");
			if(ch) sb.append("Suspicious bugs found!\n");
			else sb.append("No suspicious bugs found!\n");
            sb.append("\n");
		}
		
		System.out.print(sb.toString().trim());
	}
}