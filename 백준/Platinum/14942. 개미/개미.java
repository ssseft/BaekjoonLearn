import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] energy = new int[n+1];
        List<int[]>[] list = new ArrayList[n+1];

        for(int i =1;i<=n;i++){
            energy[i] = Integer.parseInt(br.readLine());
            list[i] = new ArrayList<>();
        }

        for(int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new int[]{e,v});
            list[e].add(new int[]{s,v});
        }

        int[][][] arr = new int[15][n+1][2];
        int[] dep = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(new int[]{1,0});

        while(!q.isEmpty()){
            int[] c = q.poll();
            int node = c[0];
            int cnt = c[1];
            for(int[] next : list[node]){
                if(!visited[next[0]]){
                    dep[next[0]] = cnt+1;
                    visited[next[0]] = true;
                    arr[0][next[0]][0] = node;
                    arr[0][next[0]][1] = next[1];
                    q.add(new int[]{next[0],cnt+1});
                }
            }
        }
        
        for(int i = 1;i<15;i++) {
        	for(int j = 1;j<=n;j++) {
        		int[] before = arr[i-1][arr[i-1][j][0]];
        		arr[i][j][0] = before[0];
        		arr[i][j][1] = before[1]+arr[i-1][j][1];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(1+"\n");
        for(int i = 2;i<=n;i++) {
        	int c = i;
        	for(int j = 14;j>=0;j--) {
        		int parent = arr[j][c][0];
        		int val = arr[j][c][1];
        		if(parent==0) continue; // 맨 위면 탈락
        		if(val<=energy[i]) {
        			energy[i] -= val;
        			c = parent;
        		}
        	}
        	sb.append(c+"\n");
        }
        System.out.print(sb);
    }
}