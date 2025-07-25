package beakjoon1;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int left = 0;
		int right = n-1;
		int min = Integer.MAX_VALUE;
		int index1 = 0;
		int index2 = n-1;
		while(left<right) {
			if(min>=Math.abs(arr[left]+arr[right])) {
				min = Math.abs(arr[left]+arr[right]);
				index1=left;
				index2=right;
			}
			if(Math.abs(arr[left]+ arr[right-1])>Math.abs(arr[left+1]+arr[right])) {
				left++;
			}
			else {
				right--;
			}
			
		}
		System.out.print(arr[index1]+" "+arr[index2]);
	}
}
