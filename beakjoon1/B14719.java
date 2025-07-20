package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;	

public class B14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[w];
		for(int i = 0; i<w;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] leftMax = new int[w];
		int[] rightMax = new int[w];
		leftMax[0] = arr[0];
		rightMax[w-1] = arr[w-1];
		for(int i = 1; i<w;i++) {
			leftMax[i] = Math.max(leftMax[i-1], arr[i]);
		}
		for(int i = w-2;i>=0;i--) {
			rightMax[i] = Math.max(rightMax[i+1], arr[i]);
		}
		
		int sum = 0;
		for(int i =0; i<w;i++) {
			sum+= (Math.min(leftMax[i], rightMax[i])-arr[i]);
		}
		System.out.print(sum);
	}
}
