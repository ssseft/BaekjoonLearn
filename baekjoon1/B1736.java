package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1736 {
	static int[][] field;
	static int n,m,trash;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		field= new int[n][m];
		
		trash = 0;
		List<int[]> list = new ArrayList<>(); 
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=  0;j<m;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j]==1) {
					trash++;
					list.add(new int[] {i,j});
				}
			}
		}
		
		int cnt=  0;
		int[] start;
		
		while(trash>0){
			for(int i =0;i<list.size();i++) {
				int[] c = list.get(i);
				if(field[c[0]][c[1]]==1) {
					trash--;
					field[c[0]][c[1]] = 0;
					start = new int[] {c[0],c[1]};
					break;
				}
			}
			
			cnt++;
			
		}
		System.out.print(cnt);
		
		
	}
}
