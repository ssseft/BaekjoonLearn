import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long cnt = 0;
		int idx = 1;
		for(int i = 0;i<n;i++) {
			if(arr[i]<=idx) {
				idx = arr[i]+1;
			}
			else {
				cnt+= (arr[i]-idx);
				idx++;
			}
		}
		
		System.out.print(cnt);
	}
}