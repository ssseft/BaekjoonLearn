import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new ArrayList[v+1];
		for(int i = 1;i<=v;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i =0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[start].add(new int[] {end,value});
			list[end].add(new int[] {start,value});
		}
		
		st = new StringTokenizer(br.readLine());
		int starnum = Integer.parseInt(st.nextToken());
		int stardis = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new ArrayDeque<>();
		
		
		int[] dijToStar = new int[v+1];
		Arrays.fill(dijToStar, 1000000000);
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<starnum;i++) {
			int c = Integer.parseInt(st.nextToken());
			q.add(new int[] {c,0});
			dijToStar[c] = 0;
		}
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int curnode = c[0];
			int curvalue = c[1];
			if(dijToStar[curnode]<curvalue) continue;
			
			for(int[] next : list[curnode]) {
				int nextnode = next[0];
				int nextvalue = next[1];
				if(curvalue+nextvalue>stardis||dijToStar[nextnode]==0) continue;
				if(curvalue+nextvalue<dijToStar[nextnode]) {
					dijToStar[nextnode] = curvalue+nextvalue;
					q.add(new int[] {nextnode,dijToStar[nextnode]});
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int macnum = Integer.parseInt(st.nextToken());
		int macdis = Integer.parseInt(st.nextToken());
		int[] dijToMac = new int[v+1];
		Arrays.fill(dijToMac,  1000000000);
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<macnum;i++) {
			int c = Integer.parseInt(st.nextToken());
			q.add(new int[] {c,0});
			dijToMac[c] = 0;
		}
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int curnode = c[0];
			int curvalue = c[1];
			if(dijToMac[curnode]<curvalue) continue;
			
			for(int[] next : list[curnode]) {
				int nextnode = next[0];
				int nextvalue = next[1];
				if(curvalue+nextvalue>macdis||dijToMac[nextnode]==0) continue;
				if(curvalue+nextvalue<dijToMac[nextnode]) {
					dijToMac[nextnode] = curvalue+nextvalue;
					q.add(new int[] {nextnode,dijToMac[nextnode]});
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1;i<=v;i++) {
			int a = dijToMac[i];
			int b = dijToStar[i];
			if(a==0||b==0||a>macdis||b>stardis) continue;
			min = Math.min(min, dijToMac[i]+dijToStar[i]);
		}
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.print(min);
	}
}
