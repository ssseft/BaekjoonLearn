import java.io.*;
import java.util.*;

public class Main {
	static List<int[]>[] list;
	static int[] depth;
	static int[][][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) 
			list[i] = new ArrayList<>();
		depth = new int[n+1];
		arr = new int[n+1][19][3]; //노드, 최소값, 최대값
		
		for(int i = 0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,v});
			list[b].add(new int[] {a,v});
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,0});
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int node = c[0];
			int dep = c[1];
			for(int[] next : list[node]) {
				int nextnode = next[0];
				int value = next[1];
				if(visited[nextnode]) continue;
				visited[nextnode] = true;
				depth[nextnode] = dep+1;
				arr[nextnode][0][0] = node;
				arr[nextnode][0][1] = value;
				arr[nextnode][0][2] = value;
				q.add(new int[] {nextnode,dep+1});
			}
		}
		
		arr[1][0][0]=1;
		arr[1][0][1] = Integer.MAX_VALUE;
		arr[1][0][2] = Integer.MIN_VALUE;
		for(int i = 1;i<19;i++) {
			for(int j = 1;j<=n;j++) {
				arr[j][i][0] = arr[arr[j][i-1][0]][i-1][0];
				arr[j][i][1] = Math.min(arr[j][i-1][1],arr[arr[j][i-1][0]][i-1][1]);
				arr[j][i][2] = Math.max(arr[j][i-1][2],arr[arr[j][i-1][0]][i-1][2]);
			}
		}
		int k = Integer.parseInt(br.readLine());
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int[] res = cal(s,e);
			sb.append(res[0]+" "+res[1]+"\n");
		}
		System.out.print(sb);
	}
	public static int[] cal(int a,int b){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
        if(depth[a]<depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        
        int diff = depth[a]-depth[b];
        
        for(int i = 0;i<19;i++){
            if((diff&(1<<i))!=0){
            	min = Math.min(min, arr[a][i][1]);
            	max = Math.max(max, arr[a][i][2]);
            	a=arr[a][i][0];
            }
        }
        
        if(a==b) return new int[] {min,max};
        
        for(int i = 18;i>=0;i--) {
        	if(arr[a][i][0]!=arr[b][i][0]) {
        		min = Math.min(min, Math.min(arr[a][i][1], arr[b][i][1]));
        		max = Math.max(max, Math.max(arr[a][i][2], arr[b][i][2]));
        		a = arr[a][i][0];
        		b = arr[b][i][0];
        	}
        }
        min = Math.min(min, arr[a][0][1]);
        max = Math.max(max, arr[a][0][2]);
        min = Math.min(min, arr[b][0][1]);
        max = Math.max(max, arr[b][0][2]);
        return new int[] {min,max};
    }
}
