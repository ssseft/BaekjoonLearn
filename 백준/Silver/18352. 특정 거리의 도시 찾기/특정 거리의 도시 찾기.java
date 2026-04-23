import java.io.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer> list;
	public static int k;
	public static int n;
	public static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        
		list = new ArrayList<>();
		bfs(x);
		StringBuilder sb = new StringBuilder();
		
		
		for(Integer num: list) {
			sb.append(num).append("\n");
		}
		System.out.print(list.isEmpty() ? -1: sb);
		
	}
	public static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start,0});
		int[] distance = new int[n+1];
		for (int i = 1; i <= n; i++) {
            distance[i] = -1;        }
		distance[start] = 0;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			if(current[1]>k)
				continue;
			
			for(int city : arr[current[0]]) {
				if(distance[city] == -1) {
					distance[city] = current[1]+1;
					q.offer(new int[] {city, current[1]+1});
				}
			}
			
		}
		for(int i =1;i<n+1;i++) {
			if(distance[i] == k) {
				list.add(i);
			}
		}
	}
}