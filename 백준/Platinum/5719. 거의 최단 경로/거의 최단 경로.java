import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        List<int[]>[] list = new ArrayList[501];
        List<int[]>[] rev  = new ArrayList[501];
        for(int i = 0;i<501;i++) {
        	list[i] = new ArrayList<>();
        	rev[i] = new ArrayList<>();
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[][] use = new boolean[501][501];
        while(true) {
        	 st = new StringTokenizer(br.readLine());
        	 
        	 int n = Integer.parseInt(st.nextToken());
        	 int m = Integer.parseInt(st.nextToken());
        	 
        	 if(n==0) break;
        	 
        	 st = new StringTokenizer(br.readLine());
        	 int StartNode = Integer.parseInt(st.nextToken());
        	 int EndNode = Integer.parseInt(st.nextToken());
        	 
        	 for(int i = 0;i<n;i++) {
        		 list[i].clear();
        		 rev[i].clear();
        		 Arrays.fill(use[i], false);
        	 }
        	 
        	 q.clear();
        	 for(int i = 0;i<m;i++) {
        		 st = new StringTokenizer(br.readLine());
        		 int s = Integer.parseInt(st.nextToken());
        		 int e = Integer.parseInt(st.nextToken());
        		 int v = Integer.parseInt(st.nextToken());
        		 list[s].add(new int[] {e,v});
        		 rev[e].add(new int[]{s, v});
        	 }
        	 
        	 q.add(new int[] {StartNode,0});
        	 int[] dij = new int[n];
        	 Arrays.fill(dij, Integer.MAX_VALUE);
        	 dij[StartNode] = 0;
        	 while(!q.isEmpty()) {
        		 int[] c = q.poll();
        		 int curnode = c[0];
        		 int curvalue = c[1];
        		 if(curvalue > dij[curnode]) continue;
        		 for(int[] next : list[curnode]) {
        			 int nextnode = next[0];
        			 int nextvalue = next[1];
        			 if(curvalue+nextvalue<dij[nextnode]) {
        				 dij[nextnode] = curvalue+nextvalue;
        				 q.add(new int[] {nextnode,dij[nextnode]});
        			 }
        		 }
        	 }
        	 
        	 int min = dij[EndNode];
        	 
        	 Queue<Integer> queue = new ArrayDeque<>();
             boolean[] visited = new boolean[n];
             queue.add(EndNode);
             visited[EndNode] = true;
             
             while(!queue.isEmpty()) {
            	 int c = queue.poll();
            	 for(int[] next : rev[c]) {
            		 int nextnode = next[0];
            		 int nextvalue = next[1];
            		 if(dij[nextnode]==Integer.MAX_VALUE) continue;
            		 if(dij[nextnode]+nextvalue==dij[c]) {
            			 use[nextnode][c] = true;
            			 if(!visited[nextnode]) {
            				 visited[nextnode] = true;
            				 queue.add(nextnode);
            			 }
            		 }
            	 }
             }
        	 
        	 
        	 Arrays.fill(dij, Integer.MAX_VALUE);
        	 dij[StartNode] = 0;
        	 q.add(new int[] {StartNode,0});
        	 while(!q.isEmpty()) {
        		 int[] c = q.poll();
        		 int curnode = c[0];
        		 int curvalue = c[1];
        		 for(int[] next : list[curnode]) {
        			 int nextnode = next[0];
        			 int nextvalue = next[1];
        			 if(use[curnode][nextnode]) continue;
        			 if(curvalue+nextvalue<dij[nextnode]) {
        				 dij[nextnode] = curvalue+nextvalue;
        				 q.add(new int[] {nextnode,dij[nextnode]});
        			 }
        		 }
        	 }
        	 sb.append(dij[EndNode]==Integer.MAX_VALUE ? -1 : dij[EndNode]).append("\n");
        }
        System.out.print(sb);
	}
}
