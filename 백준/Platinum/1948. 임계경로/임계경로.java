import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] degree = new int[n+1];
        int[] degree2 = new int[n+1];
        int[] maxtime = new int[n+1];
        
        List<int[]>[] list = new ArrayList[n+1];
        List<int[]>[] list2 = new ArrayList[n+1];
        for(int i = 1;i<=n;i++) {
        	list[i] = new ArrayList<>();
        	list2[i] = new ArrayList<>();
        }
        
        for(int i = 0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	list[s].add(new int[] {e,v});
        	list2[e].add(new int[] {s,v});
        	degree[e]++;
        	degree2[s]++;
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {start,0});
        
        while(!q.isEmpty()) {
        	int[] c = q.poll();
        	int curnode = c[0];
        	int curvalue = c[1];
        	for(int[] Next : list[curnode]){        	
        		int nextnode = Next[0];
        		int nextvalue = Next[1];
        		degree[nextnode]--;
        		int total = curvalue+nextvalue;
        		if(total>maxtime[nextnode]) maxtime[nextnode] = total;
        		
        		if(degree[nextnode]==0) {
        			q.add(new int[] {nextnode,maxtime[nextnode]});
        		}
        	}
        	
        }
        int cnt = 0;
        q.clear();
        boolean[] visited = new boolean[n+1];
        q.add(new int[] {end,maxtime[end]});
        while(!q.isEmpty()) {
        	int[] c = q.poll();
        	int curnode = c[0];
        	int curvalue = c[1];
        	for(int[] next : list2[curnode]) {
        		int nextnode = next[0];
        		int nextvalue = next[1];
        		if(curvalue-nextvalue==maxtime[nextnode]) cnt++;
        		degree2[nextnode]--;
        		
        		
        		if(curvalue-nextvalue==maxtime[nextnode]&&!visited[nextnode]) {
        			visited[nextnode] = true;
        			q.add(new int[] {nextnode,curvalue-nextvalue});
        		}
        	}
        }
        System.out.println(maxtime[end]);
        System.out.print(cnt);
	}
}
