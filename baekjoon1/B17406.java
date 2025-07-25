package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B17406 {
	static int n,m,k;
	static int[][] arr;
	static List<int[]> list;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr= new int[n+1][m+1];
		for(int i=  1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<>();
		for(int i = 0;i<k;i++) {
			st=  new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new int[] {r,c,s});
		}
		answer = Integer.MAX_VALUE;
		boolean[] used = new boolean[k];
		backtracking(0,used,arr);
		System.out.println(answer);
	}
	static int[][] rotation(int[][] arr,int num) {
		int[][] new_arr = new int[n+1][m+1];
		int[] d = list.get(num);
		for(int i = 1;i<=n;i++) {
			new_arr[i] = arr[i].clone();
		}
		int r = d[0];
		int c = d[1];
		int s = d[2];
		for(int i = 1;i<=s;i++) {
			int left = c-i;
			int right = c+i;
			int top = r-i;
			int bottom = r+i;
			//위쪽
			for(int j = left+1;j<=right;j++) {
				new_arr[top][j] = arr[top][j-1];
			}
			//아래쪽
			for(int j = right-1;j>=left;j--) {
				new_arr[bottom][j] = arr[bottom][j+1];
			}
			//왼쪽
			for(int j = bottom-1;j>=top;j--) {
				new_arr[j][left] = arr[j+1][left];
			}
			//오른쪽
			for(int j = top+1;j<=bottom;j++) {
				new_arr[j][right] = arr[j-1][right];
			}
			
			
			
		}

		
		return new_arr;
	}
	static void backtracking(int cnt,boolean[] used,int[][] new_arr) {
		if(cnt==k) {
			
			answer = Math.min(answer, cal(new_arr));
			return;
		}
		
		for(int i = 0;i<k;i++) {
			if(!used[i]) {
				used[i] = true;
				int[][] d = new int[n+1][m+1];
				for(int j = 1;j<=n;j++) {
					d[j] = new_arr[j].clone();
				}
				new_arr = rotation(new_arr,i);
				backtracking(cnt+1,used,new_arr);
				used[i] = false;
				for(int j = 1;j<=n;j++) {
					new_arr[j] = d[j].clone();
				}
			}
		}
	}
	static int cal(int[][] new_arr) {
		int min = Integer.MAX_VALUE;
		for(int i = 1;i<=n;i++) {
			int sum = 0;
			for(int j = 1;j<=m;j++) {
				sum+=new_arr[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
}
