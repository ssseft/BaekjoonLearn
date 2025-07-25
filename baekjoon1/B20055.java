package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[2*n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<2*n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		boolean[] robot = new boolean[n];
		
		int cnt = 0;
		for(int i = 0; i<2*n;i++) {
			if(arr[i]==0) {
				cnt++;
			}
		}
		
		while(cnt<k) {
			int to = arr[2*n-1];
			for(int i = 2*n-1;i>0;i--) {
				arr[i] = arr[i-1];
			}
			arr[0] = to;
			
			for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
			robot[0] = false;
			
			if(robot[n-2]&&arr[n-1]!=0) {
				robot[n-2] = false;
				arr[n-1]--;
				if(arr[n-1] == 0) {
					cnt++;
				}
			}
			
			for(int i = n-3; i>=0;i--) {
				if(robot[i]&&arr[i+1]>0&&!robot[i+1]) {
					robot[i] = false;
					robot[i+1] = true;
					arr[i+1]--;
					if(arr[i+1]==0) {
						cnt++;
					}
				}
			}
			if(arr[0]>0) {
				robot[0] = true;
				arr[0]--;
				if(arr[0] == 0) {
					cnt++;
				}
			}
			time++;
		}
		System.out.println(time);
		
		
	}
}
