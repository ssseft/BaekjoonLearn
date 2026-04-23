import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[] arr[] = new char[n][m];
			for(int j=  0;j<n;j++) {
				String line = br.readLine();
				for(int k = 0;k<m;k++) {
					arr[j][k] = line.charAt(k);
				}
			}
			boolean ch = true;
			
			for(int j = 0;j<m;j++) {
				for(int k =n-1;k>=0;k--) {
					if(k>0&&arr[k][j]=='.'&&arr[k-1][j]=='.') {
						if(j<m-1&&arr[k][j+1]=='.') {
							arr[k][j] = 'a';
							arr[k-1][j] = 'a';
							arr[k][j+1] = 'a';
						}
					}
					if(k>0&&arr[k][j]=='.') {
						if(j<m-1&&arr[k][j+1]=='.'&&arr[k-1][j+1]=='.') {
							arr[k][j] = 'b';
							arr[k][j+1] = 'b';
							arr[k-1][j+1] = 'b';
						}
					}
				}
			}
			
			
			for(int j = 0;j<n;j++) {
				for(int k = 0;k<m;k++) {
					if(arr[j][k]=='.') {
						ch = false;
					}
				}
				if(!ch) break;
			}
			
			if(ch) {
				for(int j = 0;j<n;j++) {
					for(int k = 0;k<m;k++) {
						char a = arr[j][k];
						sb.append(a);
					}
					sb.append("\n");
				}
			}
			else sb.append(-1+"\n");
		}
		System.out.println(sb.toString());
	}
}