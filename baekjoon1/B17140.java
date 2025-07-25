package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B17140 {
	static int r_length,c_length;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[101][101];
		for(int i = 1; i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<4;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		r_length = 3;
		c_length = 3;
		int cnt = 0;
		while(cnt<=100) {
			if(arr[r][c]==k) {
				System.out.print(cnt);
				return;
			}
			
			if(r_length>=c_length) {
				arr = Rcal();
			}
			else {
				arr = Ccal();
			}
			cnt++;
		}
		System.out.print(-1);
		
	}
	public static int[][] Rcal() {
		int[][] arr2 = new int[101][101];
		int[]nums;
		PriorityQueue<int[]> q;
		int maxcol = -1;
		for(int i = 1; i<=r_length;i++) {
			nums = new int[101];
			q = new PriorityQueue<int[]>((a,b)-> a[1]==b[1]? a[0]-b[0] : a[1]-b[1]);
			for(int j = 1; j<=c_length;j++) {
				if(arr[i][j]!=0) {
					nums[arr[i][j]]++;
				}
			}
			for(int j = 1; j<=100;j++)	{
				if(nums[j]>0) {
					q.add(new int[] {j,nums[j]});
				}
			} 
			int index = 1;
			while(!q.isEmpty()) {
				int[] c = q.poll();
				arr2[i][index++] = c[0];
				arr2[i][index++] = c[1];
				if(index>100) {
					break;
				}
			}
			maxcol = Math.max(maxcol, index-1);
		}
		c_length = maxcol;
		return arr2;
	}
	public static int[][] Ccal() {
		int[][] arr2 = new int[101][101];
		int[]nums;
		PriorityQueue<int[]> q;
		int maxrow = -1;
		for(int i = 1; i<=c_length;i++) {
			nums = new int[101];
			q = new PriorityQueue<int[]>((a,b)-> a[1]==b[1]? a[0]-b[0] : a[1]-b[1]);
			for(int j = 1; j<=r_length;j++) {
				if(arr[j][i]!=0) {
					nums[arr[j][i]]++;
				}
			}
			for(int j = 1; j<=100;j++)	{
				if(nums[j]>0) {
					q.add(new int[] {j,nums[j]});
				}
			} 
			int index = 1;
			while(!q.isEmpty()) {
				int[] c = q.poll();
				arr2[index++][i] = c[0];
				arr2[index++][i] = c[1];
				if(index>100) {
					break;
				}
			}
			maxrow = Math.max(maxrow, index-1);
		}
		r_length = maxrow;
		return arr2;
	}
}
