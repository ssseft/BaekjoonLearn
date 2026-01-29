import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][6];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<6;j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = -1;
		boolean[] use;
		for(int f = 1;f<=6;f++) {
			int total = 0;
			int c = f;
			for(int i = 0;i<n;i++) {
				use = new boolean[7];
				use[c] = true;
				if(arr[i][0]==c) c = arr[i][5];
				else if(arr[i][1]==c) c = arr[i][3];
				else if(arr[i][2]==c) c = arr[i][4];
				else if(arr[i][3]==c) c = arr[i][1];
				else if(arr[i][4]==c) c = arr[i][2];
				else c = arr[i][0];
				use[c] = true;
				for(int j = 6;j>=1;j--) {
					if(!use[j]) {
						total+=j;
						break;
					}
				}
			}
			max = Math.max(max, total);
		}
		System.out.print(max);
	}
}
