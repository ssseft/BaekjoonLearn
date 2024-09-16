package beakjun;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class B2212 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i =0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] distance = new int[n-1];
		for(int i= 0; i<n-1;i++) {
			distance[i] = arr[i+1] - arr[i];
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> b.compareTo(a));
		
		for(int i =0; i<n-1;i++) {
			q.add(distance[i]);
		}
		
		if(k==1) {
			System.out.print(arr[n-1]-arr[0]);
		}
		else {
			for(int i =0; i<k-1;i++) {
				q.poll();
			}
			int result =0;
			while(!q.isEmpty()) {
				result+=q.poll();
			}
			System.out.print(result);
		}
	}
}