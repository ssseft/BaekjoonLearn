package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B20187 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Stack<Character> s = new Stack<>();
		for(int i = 0;i<2*k;i++) {
			char c = st.nextToken().charAt(0);
			s.add(c);
		}
		int hole = Integer.parseInt(br.readLine());
		int[][] arr = new int[1][1];
		arr[0][0] = hole;
		
		while(!s.isEmpty()) {
			char c = s.pop();
			arr = cal(arr,c);
			
		}
		for(int i = 0;i<arr.length;i++) {
			for(int j=  0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int[][] cal(int[][] arr,char c) {
		int[][] arr2;
		if(c=='R'||c=='L') {
			arr2 = new int[arr.length][arr[0].length*2];
		}
		else {
			arr2 = new int[arr.length*2][arr[0].length];
		}
		
		
		if(c=='R') {
			for(int i = 0;i<arr.length;i++) {
				for(int j = 0;j<arr[0].length;j++) {
					arr2[i][j+arr[0].length] = arr[i][j];
					arr2[i][arr[0].length-j-1] = arr[i][j]^1;
				}
			}
		}
		
		if(c=='L') {
			for(int i = 0;i<arr.length;i++) {
				for(int j= 0;j<arr[0].length;j++) {
					arr2[i][j] = arr[i][j];
					arr2[i][arr[0].length*2-1-j] = arr[i][j]^1;
				}
			}
		}
		
		if(c=='U') {
			for(int i = 0;i<arr.length;i++) {
				for(int j=  0;j<arr[0].length;j++) {
					arr2[i][j] = arr[i][j];
					arr2[2*arr.length-1-i][j] = arr[i][j]^2;
				}
			}
		}
		if(c=='D') {
			for(int i = 0;i<arr.length;i++) {
				for(int j =0;j<arr[0].length;j++) {
					arr2[i+arr.length][j] = arr[i][j];
					arr2[arr.length-1-i][j] = arr[i][j]^2;
				}
			}
		}
		
		return arr2;
	}
}
