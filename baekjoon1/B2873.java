package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2873 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[r][c];
		int min = 1000;
		int minx = 0;
		int miny = 0;
		for(int i = 0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<c;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]<min&&(i+j)%2==1&&!(i==0&&j==0)&&!(i==r-1&&j==c-1)) {
					min = arr[i][j];
					minx = i;
					miny = j;
				}
			}
		}
		
		if(r%2==1) {
			boolean odd = true;
			for(int i = 0;i<r;i++) {
				for(int j = 0;j<c-1;j++) {
					if(odd) sb.append("R");
					else sb.append("L");
				}
				if(i!=r-1)sb.append("D");
				odd = !odd;
			}
		}
		else if(c%2==1) {
			boolean odd = true;
			for(int i = 0;i<c;i++) {
				for(int j =0;j<r-1;j++) {
					if(odd) sb.append("D");
					else sb.append("U");
				}
				if(i!=r-2)sb.append("R");
				odd = !odd;
			}
		}
		else {
			boolean odd = true;
			for(int i = 0;i<r;i+=2) {
				if(minx!=i&&minx!=i+1) {
					if(odd) {
						for(int j = 0;j<c-1;j++) sb.append("R");
						sb.append("D");
						for(int j = 0;j<c-1;j++) sb.append("L");
						if(i!=r-2) sb.append("D");
					}
					else {
						for(int j = 0;j<c-1;j++) sb.append("L");
						sb.append("D");
						for(int j = 0;j<c-1;j++) sb.append("R");
						if(i!=r-2) sb.append("D");
					}
					
				}
				else {
					boolean down = true;
					if(odd) {
						for(int j = 0;j<c-1;j++) {
							if((down&&minx==i+1&&miny==j)||(!down&&minx==i&&miny==j)) {
								break;
							}
							else {
								if(down) {
									sb.append("D");
									sb.append("R");
									down = !down;
								}
								else {
									sb.append("U");
									sb.append("R");
									down = !down;
								}
							}
						}
						if(miny!=c-1)sb.append("R");
						for(int j = miny;j<c-1;j++) {
							if(down) {
								sb.append("D");
								if(j!=c-2)sb.append("R");
								down = !down;
							}
							else {
								sb.append("U");
								if(j!=c-2)sb.append("R");
								down = !down;
							}
						}
					}
					if(i!=r-2) sb.append("D");
					odd = !odd;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
