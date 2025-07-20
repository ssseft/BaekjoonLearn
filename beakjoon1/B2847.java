package beakjoon1;
import java.io.*;

public class B2847 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = arr[n-1];
		int cnt = 0;
		for(int i = n-2;i>=0;i--) {
			if(max<=arr[i]) {
				cnt += arr[i]-max+1;
				arr[i] = max-1;
			}
			max = arr[i];
		}
		System.out.print(cnt);
	}
}