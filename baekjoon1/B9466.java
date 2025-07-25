package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B9466 {
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n+1];
			for(int i = 1;i<=n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] include = new boolean[n+1];
			int cnt = 0;
			list = new ArrayList<>();
			for(int i =1;i<=n;i++) {
				if(include[i]) continue;
				boolean[] visited = new boolean[n+1];
				visited[i] = true;
				int cur = cal(0,arr[i],i,arr,visited,include);
				System.out.println(i+" "+cur);
				list.add(i);
				list.add(arr[i]);
				if(cur!=0) {
					cnt++;
					for(int c : list) {
						include[c] = true;
					}
				}
				list.clear();
			}
			
			
			sb.append(n-cnt+"\n");
		}
		System.out.print(sb.toString());
	}
	static int cal(int cnt,int c,int start,int[] arr, boolean[] visited,boolean[] include) {
		int next = arr[c];
		list.add(arr[c]);
		visited[c] = true;
		if(next==start) return cnt+1;
		if(visited[next]) return 0;
		
		
		return cal(cnt+1,next,start,arr,visited,include);
	}
}
