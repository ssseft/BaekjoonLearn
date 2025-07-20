package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B20058 {
	static int[][] arr,new_arr;
	static int n,max,block;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	static Queue<int[]> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, n);
		arr = new int[size+1][size+1];
		new_arr = new int[size+1][size+1];
		for(int i = 1;i<=size;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=size;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while(q-->0) {
			rotation(Integer.parseInt(st.nextToken()));
			for(int i = 1;i<=size;i++) {
				arr[i] = new_arr[i].clone();
			}
			new_arr = new int[size+1][size+1];
			int[][] zero = new int[size+1][size+1];
			for(int i =1;i<=size;i++) {
				zero[1][i]++;
				zero[size][i]++;
				zero[i][1]++;
				zero[i][size]++;
			}
			for(int i= 1;i<=size;i++) {
				for(int j =1;j<=size;j++) {
					if(arr[i][j]==0) {
						for(int k = 0;k<4;k++) {
							int cx = i+dx[k];
							int cy = j+dy[k];
							if(cx>=1&&cy>=1&&cx<=size&&cy<=size) {
								zero[cx][cy]++;
							}
						}
					}
				}
			}
			for(int i = 1;i<=size;i++) {
				for(int j =1;j<=size;j++) {
					if(zero[i][j]>=2&&arr[i][j]>0) arr[i][j]--;
				}
			}
		}
		
		max = 0;
		block = 0;
		visited = new boolean[size+1][size+1];
		queue = new LinkedList<>();
		for(int i = 1;i<=size;i++) {
			for(int j = 1;j<=size;j++) {
				if(arr[i][j]>0&&!visited[i][j]) {
					block += arr[i][j];
					visited[i][j] = true;
					queue.add(new int[] {i,j});
					bfs();
				}
			}
		}
		System.out.println(block);
		System.out.print(max);
	}
	static void bfs() {
		int cnt = 1;
		int size = (int)Math.pow(2, n);
		while(!queue.isEmpty()){
			int[] c = queue.poll();
			for(int i = 0;i<4;i++) {
				int cx = c[0]+dx[i];
				int cy = c[1]+dy[i];
				if(cx>=1&&cy>=1&&cx<=size&&cy<=size&&!visited[cx][cy]&&arr[cx][cy]>0) {
					cnt++;
					visited[cx][cy] = true;
					queue.add(new int[] {cx,cy});
					block+=arr[cx][cy];
				}
			}
		}
		max = Math.max(max, cnt);
	}
	static void rotation(int L) {
		int size = (int)Math.pow(2, n);
		int bsize = (int)Math.pow(2, L);
		for(int i = 1;i<=size;i+=bsize) {
			for(int j = 1;j<=size;j+=bsize){
				for(int x=  0;x<bsize;x++) {
					for(int y = 0;y<bsize;y++) {
						new_arr[i+y][j+bsize-1-x] = arr[i+x][j+y];
					}
				}
			}
		}
	}
}
