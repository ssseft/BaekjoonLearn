package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B16235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int goal_year = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		for(int i = 1; i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] nutrient = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
		    Arrays.fill(nutrient[i], 5);
		}
		
		List<Integer>[][] list = new ArrayList[n+1][n+1];		
		
		for(int i = 1; i<=n;i++	) {
			for(int j = 1; j<=n;j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			list[x][y].add(year);
		}
		
		for(int i = 0; i<goal_year;i++) {
			
			int[][] added_nutrient = new int[n+1][n+1];
			List<Integer>[][] new_field = new ArrayList[n+1][n+1];
			
			for(int j = 1; j<=n;j++	) {
				for(int k = 1; k<=n;k++) {
					new_field[j][k] = new ArrayList<>();
				}
			}
			
			List<int[]> added_field = new ArrayList<>();
			for(int j = 1; j<=n;j++) {
				for(int k = 1;k<=n;k++) {
					Collections.sort(list[j][k]);
					int size = list[j][k].size();
					for(int a = 0; a<size;a++) {
						int c = list[j][k].get(a);
						if(c<=nutrient[j][k]) {
							nutrient[j][k]-=c;
							new_field[j][k].add(c+1);
							if((c+1)%5==0) {
								added_field.add(new int[] {j,k});
							}
						}
						else {
							added_nutrient[j][k] += (c/2);
						}
					}
					
					
				}
			}
			
			//가을
			for(int j = 0; j<added_field.size();j++) {
				int[] a = added_field.get(j);
				int dx = a[0];
				int dy = a[1];
				if(1<dx) {
					if(1<dy) {
						new_field[dx-1][dy-1].add(1);
					}
					if(dy<n) {
						new_field[dx-1][dy+1].add(1);
					}
					new_field[dx-1][dy].add(1);
				}
				if(dx<n) {
					if(1<dy) {
						new_field[dx+1][dy-1].add(1);
					}
					if(dy<n) {
						new_field[dx+1][dy+1].add(1);
					}
					new_field[dx+1][dy].add(1);
				}
				if(1<dy) {
					new_field[dx][dy-1].add(1);
				}
				if(dy<n) {
					new_field[dx][dy+1].add(1);
				}
			}
			
			//겨울
			for(int j = 1; j<=n;j++) {
				for(int k = 1; k<=n;k++) {
					nutrient[j][k] += (arr[j][k]+added_nutrient[j][k]);
				}
			}
			
			
			list = new_field;
		}
		int cnt = 0;
		for(int i = 1; i<=n;i++) {
			for(int j = 1; j<=n;j++) {
				cnt+=list[i][j].size();
			}
		}
		System.out.println(cnt);
	}
}
