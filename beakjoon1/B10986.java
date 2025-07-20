package beakjoon1;
import java.io.*;
import java.util.StringTokenizer;

public class B10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[]arr = new long[m];
		long sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n;i++) {
			sum +=Integer.parseInt(st.nextToken());
            arr[(int)(sum%m)]++;
		}
		long cnt = 0;
		cnt += arr[0];
		for(int i = 0; i<m;i++) {
			cnt+=cal(arr[i]);
		}
		
		System.out.print(cnt);
	}
	public static long cal(long s) {
		long value =  s*(s-1)/2;
		return value;
	}
}
