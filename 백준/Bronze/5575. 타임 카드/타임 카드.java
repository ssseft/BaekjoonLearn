import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][6];
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<6;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0;i<3;i++) {
			int s,m,h;
			if(arr[i][5]<arr[i][2]) {
				if(arr[i][4]!=0) arr[i][4]--;
				else {
					arr[i][3]--;
					arr[i][4] = 59;
				}
				s = 60+arr[i][5]-arr[i][2];
			}
			else s = arr[i][5]-arr[i][2];
			
			if(arr[i][1]>arr[i][4]) {
				arr[i][3]--;
				m = 60+arr[i][4]-arr[i][1];
			}
			else {
				m = arr[i][4]-arr[i][1];
			}
			
			h = arr[i][3]-arr[i][0];
			
			System.out.println(h+" "+m+" "+s);
		}
	}
}