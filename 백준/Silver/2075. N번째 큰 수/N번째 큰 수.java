import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n*n];
		StringTokenizer st;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i*n+j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr);
		
		System.out.println(arr[n*n-n]);
	}
}