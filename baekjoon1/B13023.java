package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B13023 {
	static boolean find;
	static int n,m;
	static List<List<Integer>> graph;
	static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
            graph.get(e).add(s);
		}
		find = false;
		
		
		for(int i = 0;i<n;i++) {
			used = new boolean[n];
			used[i] = true;
			dfs(1,i);
			if(find) break;
		}
		
		System.out.println(find ? 1 : 0);
		
		
	}
	static void dfs(int cnt,int lastnum) {
		if(cnt==5) {
			find = true;
			return;
		}
		if(find) return;
		
		for(int i : graph.get(lastnum)) {
			if(!used[i]) {
				used[i] = true;
				dfs(cnt+1,i);
				used[i] = false;
			}
		}
	}
}
