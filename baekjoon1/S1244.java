package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1244 {
	static int max;
	static int[] nums;
	static int tr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0 ;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			tr = Integer.parseInt(st.nextToken());
			max = 0;
			int digcnt = (int)Math.log10(num)+1;
			nums = new int[digcnt];
			for(int j=digcnt-1; j>=0;j--) {
				nums[j] =num%10;
				num/=10;	
			}
			boolean check = false;
			if(tr>nums.length) {
				if(tr %2 == 1) {
					check = true;
				}
				tr = nums.length;
			}
			DFS(0);
			if(check) {
				int lastnum = max%10;
				max /=10;
				int lasttwonum = max%10;
				max /=10;
				max *=100;
				max+= lastnum*10+lasttwonum;
			}
			
			sb.append("#"+(i+1)+" "+max+"\n");
		}
		System.out.print(sb.toString().trim());
	}
	static void DFS(int cnt) {
		if(cnt==tr) {
			int c = 0;
			for (int i = 0; i < nums.length; i++) {
			    c += (Math.pow(10, i) * nums[nums.length - i - 1]);
			}
			if(max<c) {
				max = c;
			}
			return;
		}
		
		for(int i = 0; i<nums.length;i++) {
			for(int j = i+1;j<nums.length;j++) {
				trans(i,j);
				DFS(cnt+1);
				trans(i,j);
			}
		}
	}
	static void trans(int a,int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
