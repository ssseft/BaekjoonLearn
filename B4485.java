package beakjun;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4485 {
	static class Node{
		int cost;
		int x, y;
		Node(int cost,int x, int y){
			this.cost = cost;
			this.x = x;
			this.y = y;
		}
	}
	
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				return;
			}
			int[][] arr = new int[n][n];
			StringTokenizer st;
			for(int i = 0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
			q.add(new Node(arr[0][0],0,0));
			while(!q.isEmpty()) {
				Node current = q.poll();
				
				
				
			}
			
			
			
		}
		
		
	}
}
