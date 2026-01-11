import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n+1];
		boolean[] jump = new boolean[n+1];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<k;i++) 
			arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];
		
		
		for(int i = k;i<=n;i++) {
			int cur = Integer.parseInt(st.nextToken());
			
			if(arr[i-k]+c<arr[i-1]+cur) {
				arr[i] = arr[i-k]+c;
				jump[i] = true;
			}
			else arr[i] = arr[i-1]+cur;
		}
		
		int idx = n;
		List<Integer> list = new ArrayList<>();
		while(idx>=0) {
			if(jump[idx]) {
				list.add(idx-k+1);
				idx -= k;
			}
			else idx--;
		}
		
		sb.append(arr[n]+"\n");
		sb.append(list.size()+"\n");
		for(int i = list.size()-1;i>=0;i--) {
			sb.append(list.get(i)+"\n");
		}
		System.out.print(sb);
	}
}
