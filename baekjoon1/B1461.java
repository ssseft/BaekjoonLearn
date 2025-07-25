package beakjoon1;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr =new int[n];
		int index = 0;
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>0) {
				index++;
			}
		}
		Arrays.sort(arr);
		int left = 0;
		int right = n-1;
		int move = 0;
		index = n-index;
		if(left!=index) {
			while(left<index) {
				move += Math.abs(arr[left]);
				left+=m;
			}
		}
		if(right+1!=index) {
			while(right>=index) {
				move+= arr[right];
				right-=m;
			}
		}
		move *=2;
		move -= Math.max(Math.abs(arr[0]),Math.abs(arr[n-1])); 
		System.out.println(move);
	}
}
