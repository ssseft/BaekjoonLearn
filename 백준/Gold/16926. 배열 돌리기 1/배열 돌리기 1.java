import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] arr,new_arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		new_arr = new int[n][m];
		for(int i =0;i<n;i++) {
			new_arr[i] = arr[i].clone();
		}
		
		boolean ch = false;
		for(int i = 0;i<Math.min(n, m)/2;i++) {
			ch = false;
			int a = r % ((n-2*i)*2+(m-2*i)*2-4);
			for(int j = 0;j<a;j++) {
				if(ch) {
					rotation(i,ch);
					ch = false;
					
				}
				else {
					rotation(i,ch);
					ch = true;
					
				}
			}
		}
		
		if(ch) {
			for(int d = 0;d<n;d++) {
				for(int j = 0;j<m;j++) {
					System.out.print(arr[d][j]+" ");
				}
				System.out.println();
			}
		}
		else {
			for(int d = 0;d<n;d++) {
				for(int j = 0;j<m;j++) {
					System.out.print(new_arr[d][j]+" ");
				}
				System.out.println();
			}
		}
		
		
		
	}
	static void rotation(int l,boolean ch) {
		
		if(ch) {
			for(int i = l;i<m-l-1;i++) {
				new_arr[l][i] = arr[l][i+1];
			}
			for(int i = l;i<n-l-1;i++) {
				new_arr[i][m-1-l] = arr[i+1][m-1-l];
			}
			for(int i = l+1;i<m-l;i++) {
				new_arr[n-l-1][i] = arr[n-1-l][i-1];
			}
			for(int i = l+1;i<n-l;i++) {
				new_arr[i][l] = arr[i-1][l];
			}
		}
		else {
			for(int i = l;i<m-l-1;i++) {
				arr[l][i] = new_arr[l][i+1];
			}
			for(int i = l;i<n-l-1;i++) {
				arr[i][m-1-l] = new_arr[i+1][m-1-l];
			}
			for(int i = l+1;i<m-l;i++) {
				arr[n-l-1][i] = new_arr[n-1-l][i-1];
			}
			for(int i = l+1;i<n-l;i++) {
				arr[i][l] = new_arr[i-1][l];
			}
		}
	}
}