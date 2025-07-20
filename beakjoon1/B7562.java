package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int goalx = Integer.parseInt(st.nextToken());
			int goaly = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			q.add(new int[] {x,y});
			int cnt = 0;
			boolean goal = false;
			if(x==goalx&&y==goaly) goal = true;
			while(!goal) {
				Queue<int[]> q2 = new LinkedList<>();
				cnt++;
				while(!q.isEmpty()) {
					int[] c = q.poll();
					for(int a = 1;a<=2;a++) {
						int b = 3-a;
						if(c[0]+a<n&&c[1]+b<n&&!visited[c[0]+a][c[1]+b]) {
							q2.add(new int[] {c[0]+a,c[1]+b});
							visited[c[0]+a][c[1]+b] = true;
							if(c[0]+a==goalx&&c[1]+b==goaly) goal = true;
						}
						if(c[0]+a<n&&c[1]-b>=0&&!visited[c[0]+a][c[1]-b]) {
							q2.add(new int[] {c[0]+a,c[1]-b});
							visited[c[0]+a][c[1]-b] = true;
							if(c[0]+a==goalx&&c[1]-b==goaly) goal = true;
						}
						if(c[0]-a>=0&&c[1]-b>=0&&!visited[c[0]-a][c[1]-b]) {
							q2.add(new int[] {c[0]-a,c[1]-b});
							visited[c[0]-a][c[1]-b] = true;
							if(c[0]-a==goalx&&c[1]-b==goaly) goal = true;
						}
						if(c[0]-a>=0&&c[1]+b<n&&!visited[c[0]-a][c[1]+b]) {
							q2.add(new int[] {c[0]-a,c[1]+b});
							visited[c[0]-a][c[1]+b] = true;
							if(c[0]-a==goalx&&c[1]+b==goaly) goal = true;
						}
					}
				}
				
				q = q2;
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString().trim());
	}
}
