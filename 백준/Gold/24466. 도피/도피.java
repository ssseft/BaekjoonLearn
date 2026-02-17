import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new int[]{v, w});
        }

        long[] cur = new long[n];
        cur[0] = 1_000_000_000_000_000_000L;

        for(int day=0;day<9;day++) {
            long[] nxt = new long[n];
            for(int u=0;u<n;u++) {
                long p = cur[u];
                if(p==0) continue;
                for(int[] e:g[u]) {
                    int v = e[0];
                    int w = e[1];
                    nxt[v]+=cal(p,w);
                }
            }
            cur = nxt;
        }

        long max = -1;
        for(int i=0;i<n;i++) max = Math.max(max, cur[i]);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) if (cur[i]==max) sb.append(i).append(' ');
        System.out.println(sb.toString());
        if(max==1_000_000_000_000_000_000L)System.out.println("1."+"0".repeat(18));
        else System.out.printf("0.%018d%n", max);
    }
    static long cal(long p, int per){
        long q = p / 100;
        long r = p % 100;
        return q * per + (r * per) / 100;
    }
}
