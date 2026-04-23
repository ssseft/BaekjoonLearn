import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<int[]>[] list = new ArrayList[n+1];
        
        for(int i = 1;i<=n;i++) {
        	list[i] = new ArrayList<int[]>();
        }
        
        for(int i = 0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	list[s].add(new int[] {e,v});
        	list[e].add(new int[] {s,v});
        }
        
        long[] fox = new long[n+1];
        long[][] wolf = new long[n+1][2];
        for(int i = 1;i<=n;i++) {
        	Arrays.fill(wolf[i], Long.MAX_VALUE);
        }
        Arrays.fill(fox, Long.MAX_VALUE);
        PriorityQueue<long[]> q= new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        
        q.add(new long[] {1,0});
        fox[1] = 0;
        wolf[1][0] = 0;
        
        while(!q.isEmpty()) {
        	long[] c = q.poll();
        	int curnode = (int)c[0];
        	long value = c[1];
        	if(fox[curnode]<value) continue;
        	
        	for(int[] next : list[curnode]) {
        		int nextnode = next[0];
        		int nextvalue = next[1]*2;
        		if(fox[nextnode]>fox[curnode]+nextvalue) {
        			fox[nextnode] = fox[curnode]+nextvalue;
        			q.add(new long[] {nextnode,fox[curnode]+nextvalue});
        		}
        	}
        }
        
        q.add(new long[] {1,0,0});
        
        while(!q.isEmpty()) {
        	long[] c = q.poll();
        	int curnode = (int)c[0];
        	long value = c[1];
        	if(c[2]==0&&wolf[curnode][0]<value) continue;
        	if(c[2]==1&&wolf[curnode][1]<value) continue;
        	
        	for(int[] next : list[curnode]) {
        		int nextnode = next[0];
        		int nextvalue = next[1];
        		
        		if(c[2]==0) {
        			if(wolf[nextnode][1]>wolf[curnode][0]+nextvalue) {
            			wolf[nextnode][1] = wolf[curnode][0]+nextvalue;
            			q.add(new long[] {nextnode,wolf[curnode][0]+nextvalue,1});
            		}
        		}
        		else {
        			if(wolf[nextnode][0]>wolf[curnode][1]+nextvalue*4) {
            			wolf[nextnode][0] = wolf[curnode][1]+nextvalue*4;
            			q.add(new long[] {nextnode,wolf[curnode][1]+nextvalue*4,0});
            		}
        		}
        	}
        }
        
        int cnt = 0;
        for(int i = 1;i<=n;i++) {
        	if(fox[i]<wolf[i][0]&&fox[i]<wolf[i][1]) cnt++;
        }
        System.out.print(cnt);
	}
}