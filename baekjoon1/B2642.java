package beakjoon1;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2642 {
	public static void main(String[] args) throws IOException {
		Scanner sc=  new Scanner(System.in);
		int[][] arr = new int[6][6];
		Queue<int[]> q = new LinkedList<>();
		for(int i =0;i<6;i++) {
			for(int j = 0;j<6;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]!=0) q.add(new int[] {i,j});
			}
		}
		
		int[] op = new int[7];
		boolean[] visited = new boolean[7];
		Arrays.fill(op, -1);
		while(!q.isEmpty()) {
			int[] c = q.poll();
			boolean r = false;
			int x = c[0];
			int y = c[1];
			//이어진 방향이 오른쪽일 경우
			if(c[1]<4) {
				int cx = c[0];
				int cy = c[1]+1;
				if(arr[cx][cy]!=0) {
					cy++;
					for(int i = cx;i<6;i++) {
						if(arr[i][cy]!=0&&!visited[arr[i][cy]]&&!visited[arr[x][y]]){
							r = true;
							visited[arr[x][y]] = true;
							visited[arr[i][cy]] = true;
							op[arr[x][y]] = arr[i][cy];
							op[arr[i][cy]] = arr[x][y];
							break;
						}
					}
				}
			}
			//왼쪽일 경우
			if(c[1]>1) {
				int cx = c[0];
				int cy = c[1]-1;
				if(arr[cx][cy]!=0) {
					cy--;
					for(int i = cx+1;i<6;i++) {
						if(arr[i][cy]!=0&&!visited[arr[i][cy]]&&!visited[arr[x][y]]){
							r = true;
							visited[arr[x][y]] = true;
							visited[arr[i][cy]] = true;
							op[arr[x][y]] = arr[i][cy];
							op[arr[i][cy]] = arr[x][y];
							break;
						}
					}
				}
			}
			
			if(!r&&c[0]<4) {
				int cx = c[0]+1;
				int cy = c[1];
				if(arr[cx][cy]!=0) {
					cx++;
					for(int i = 0;i<5;i++) {
						int ly = cy-i;
						int ry = cy+i;
						if(ly>=0&&arr[cx][ly]!=0&&!visited[arr[cx][ly]]&&!visited[arr[x][y]]) {
							visited[arr[cx][ly]] = true;
							visited[arr[x][y]] = true;
							op[arr[x][y]] = arr[cx][ly];
							op[arr[cx][ly]] = arr[x][y];
							break;
						}
						
						if(ry<6&&arr[cx][ry]!=0&&!visited[arr[cx][ry]]&&!visited[arr[x][y]]) {
							visited[arr[cx][ry]] = true;
							visited[arr[x][y]] = true;
							op[arr[x][y]] = arr[cx][ry];
							op[arr[cx][ry]] = arr[x][y];
							break;
						}
					}
				}
			}
		}
		for(int i = 1;i<7;i++) {
//			if(op[i]==-1) {
//				System.out.print(0);
//				return;
//			}
			System.out.print(op[i]+" ");
		}
		System.out.print(op[1]);
	}
}
