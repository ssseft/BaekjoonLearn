package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][2];
		for(int i =0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,(a,b) -> a[0]-b[0]);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		int left,right,mid;
		int dp[] = new int[n];
		for(int i = 0 ;i<n;i++) {
			left = 1;
			right = list.size()-1;
			if(arr[i][1]>list.get(list.size()-1)) {
				list.add(arr[i][1]);
				dp[i] = list.size()-1;
			}
			else {
				while(left<right) {
					mid = (left+right)>>1;
					if(list.get(mid)>=arr[i][1]) {
						right = mid;
					}
					else {
						left = mid+1;
					}
				}
				list.set(right,arr[i][1]);
				dp[i] = right;
				
				
			}
			
		}
		boolean[] check = new boolean[n];
		int count = list.size()-1;
		
		for(int i = n-1; i>=0;i--) {
			if(dp[i]==count) {
				check[i] = true;
				count--;
				if(count==0) {
					break;
				}
			}
		}
		System.out.println(n-(list.size()-1));
		for(int i = 0; i<n;i++) {
			if(!check[i]) {
				System.out.println(arr[i][0]);
			}
		}
	}
}