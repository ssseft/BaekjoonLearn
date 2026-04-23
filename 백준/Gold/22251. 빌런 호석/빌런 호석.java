import java.util.Scanner;

public class Main {
	static int cnt = 0;
	static int n,k,p;
	static String x;
	static int[][] arr;
	static char[] cur;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		p = sc.nextInt();
		x = sc.next();
		
		arr = new int[][] {
			{0,4,3,3,4,3,2,3,1,2},
			{4,0,5,3,2,5,6,1,5,4},
			{3,5,0,2,5,4,3,4,2,3},
			{3,3,2,0,3,2,3,2,2,1},
			{4,2,5,3,0,3,4,3,3,2},
			{3,5,4,2,3,0,1,4,2,1},
			{2,6,3,3,4,1,0,5,1,2},
			{3,1,4,2,3,4,5,0,4,3},
			{1,5,2,2,3,2,1,4,0,1},
			{2,4,3,1,2,1,2,3,1,0}
		};
		
		cur = new char[k];
		for(int i =0;i<k;i++) cur[i] = '0';
		
		int index = 0;
		for(int i = k-x.length();i<k;i++) cur[i] = x.charAt(index++);
		char[] nums = cur.clone();
		
		
		recursion(0,0,nums);
		
		System.out.println(cnt);
		
		
	}
	static void recursion(int idx,int value,char[] nums) {
		if(idx==k) {
			int v1 = Integer.parseInt(new String(nums));
			int v2 = Integer.parseInt(new String(cur));
			if(v1!=v2&&v1>=1&&v1<=n) cnt++;
			return;
		}
		
		for(int i = 0;i<10;i++) {
			int s = arr[cur[idx]-'0'][i];
			if(value+s>p) continue;
			char c = nums[idx];
			nums[idx] = (char)(i+'0');
			recursion(idx+1,value+s,nums);
			nums[idx] = c;
		}
	}
}
