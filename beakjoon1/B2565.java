package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class B2565 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][2];
		for(int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		int[] dp = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i = 0; i<n;i++) {
			int left = 1;
			int right = list.size()-1;
			if(arr[i][1]>list.get(list.size()-1)) {
				list.add(arr[i][1]);
				dp[i] = list.size()-1;
			}
			else {
				while(left<right) {
					int mid = (left+right)>>1;
					if(list.get(mid)>=arr[i][1]) {
						right= mid;
					}
					else {
						left = mid+1;
					}
					
				}
				list.set(right, arr[i][1]);
				dp[i] = right;
			}
		}
		System.out.print(n-(list.size()-1));
	}
}
