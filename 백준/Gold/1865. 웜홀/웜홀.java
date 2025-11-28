import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long[] dist;
	static List<int[]>[] list;
	static int n;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(tc-->0) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	list = new ArrayList[n+1];
        	for(int i =1;i<=n;i++) {
        		list[i] = new ArrayList<>();
        	}
        	for(int i = 0;i<m+w;i++) {
        		st = new StringTokenizer(br.readLine());
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		int v = Integer.parseInt(st.nextToken());
        		if(i<m) {
            		list[e].add(new int[] {s,v});
        		}
        		else {
        			v = -v;
        		}
        		list[s].add(new int[] {e,v});
        	}
        	dist = new long[n+1];
        	boolean check = false;
        	
        	for (int i = 1; i <= n; i++) {
                if (bellmanFord(i)) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                sb.append("NO\n");
            }
            else {
            	sb.append("YES\n");
            }
        }
        
        System.out.print(sb);
	}
	public static boolean bellmanFord(int start) {
        Arrays.fill(dist, 9999999999L);
        dist[start] = 0;
        boolean update = false;
        
        for (int i = 1; i<n;i++) {
            update = false;
            
            for(int u = 1;u<=n;u++) {
                if(dist[u] == 9999999999L) continue;
                for(int[] next : list[u]) {
                    int v = next[0];
                    int w = next[1];
                    if(dist[v]>dist[u]+w) {
                        dist[v] = dist[u]+w;
                        update = true;
                    }
                }
            }
            if(!update) break;
        }
        
        if (update) {
            for (int u = 1;u<=n;u++) {
                if (dist[u] == 9999999999L) continue;
                for (int[] next : list[u]) {
                    int v = next[0];
                    int w = next[1];
                    if (dist[v] > dist[u] + w) {
                        return true;
                    }
                }
            }
        }
 
        return false;
    }
}
