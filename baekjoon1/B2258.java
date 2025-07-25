package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,(a,b)->{
			if(a[1]!=b[1]) {
				return Integer.compare(a[1], b[1]);
			}
			else {
				return Integer.compare(b[0], a[0]);
			}
		});
		
		int sum = 0;
		int min = -1;
		int sum_price = 0;
		int recent_price = 0;
		
		for(int i = 0; i<n;i++) {
			sum += arr[i][0];
			if(arr[i][1]==recent_price) {
				sum_price += arr[i][1];
			}
			else {
				sum_price = arr[i][1];
			}
			
			if(sum>=m) {
				if(min==-1) {
					min = sum_price;
				}
				else {
					min = Math.min(sum_price, min);
				}
			}
			recent_price = arr[i][1];
		}
		
		
		System.out.println(min);
	}
}
