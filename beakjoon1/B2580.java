package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B2580 {
	static boolean check;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[82];
		int index = 1;
		for(int i = 0; i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9;j++) {
				arr[index++] = Integer.parseInt(st.nextToken());
			}
		}
		check = false;
		backtracking(1);
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<10;i++) {
			for(int j = 1; j<10;j++) {
				sb.append(arr[(i-1)*9+j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
	static void backtracking(int num) {
		if(num ==82) {
			check = true;
			return;
		}
		if(arr[num]==0) {
			for(int j = 1;j<10;j++) {
				if(possible(num,j)) {
					arr[num] = j;
					backtracking(num+1);
					if(check) return;
					arr[num] = 0;
				}
			}
			
		}
		else {
			backtracking(num+1);
		}
		
	}
	
	static boolean possible(int value,int num) {
		int x = (value-1)/9;
		int y = (value-1)%9;
		for(int i = x*9+1;i<=(x+1)*9;i++) {
			if(arr[i]==num) {
				return false;
			}
		}
		for(int i = y+1;i<82;i+=9) {
			if(arr[i]==num) {
				return false;
			}
		}
		int startX = x/3*3;
		int startY = y/3*3;
		for(int i = startX; i<startX+3;i++) {
			for(int j = startY; j<startY+3;j++) {
				if(arr[i*9+j+1]==num) {
					return false;
				}
			}
		}
		return true;
	}
}
