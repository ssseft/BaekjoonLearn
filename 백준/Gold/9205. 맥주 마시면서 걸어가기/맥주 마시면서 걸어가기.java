import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			
			int[][] des = new int[n][2];
			for(int j = 0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				des[j][0] = Integer.parseInt(st.nextToken());
				des[j][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int end_x = Integer.parseInt(st.nextToken());			
			int end_y = Integer.parseInt(st.nextToken());			
			Queue<int[]> q = new LinkedList<>();
			boolean[] visited = new boolean[n];
			q.add(new int[] {start_x,start_y});
			boolean check = false;
			while(!q.isEmpty()) {
				int[] a = q.poll();
				if(Math.abs(a[0]-end_x)+Math.abs(a[1]-end_y)<=1000) {
					sb.append("happy\n");
					check = true;
					break;
				}
				for(int j = 0; j<n;j++) {
					if(Math.abs(a[0]-des[j][0])+Math.abs(a[1]-des[j][1])<=1000&&!visited[j]) {
						visited[j] =true;
						q.add(new int[] {des[j][0],des[j][1]});
					}
				}
			}
			if(!check) {
				sb.append("sad\n");
			}
		}
		System.out.print(sb.toString().trim());
	}
}