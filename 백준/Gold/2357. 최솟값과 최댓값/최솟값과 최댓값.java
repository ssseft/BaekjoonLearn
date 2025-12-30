import java.io.*;
import java.util.*;

public class Main {
	static int[][] tree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		tree = new int[4*n][2];
		for(int i = 0;i<4*n;i++) {
			tree[i][0] = Integer.MAX_VALUE;
			tree[i][1] = Integer.MIN_VALUE;
		}
		
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		create(0,n-1,1);
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int[] ans = query(1,0,n-1,start-1,end-1);
			sb.append(ans[0]+" "+ans[1]+"\n");
		}
		System.out.print(sb);
	}
	public static void create(int start,int end,int node) {
		if(start==end) {
			tree[node][0] = arr[start];
			tree[node][1] = arr[start];			
		}
		else {
			int mid = (start+end)/2;
			create(start,mid,2*node);
			create(mid+1,end,2*node+1);
			tree[node][0] = Math.min(tree[2*node][0], tree[2*node+1][0]);
			tree[node][1] = Math.max(tree[2*node][1], tree[2*node+1][1]);
		}
	}
	static int[] query(int node, int start, int end, int left, int right) {
		if(left>end||right<start) {
			return new int[] {Integer.MAX_VALUE,Integer.MIN_VALUE};
		}
		if(left<=start&&end<=right) {
			return new int[] {tree[node][0],tree[node][1]};
		}
		int mid = (start+end)/2;
		int[] l= query(node*2,start,mid,left,right);
		int[] r = query(node*2+1,mid+1,end,left,right);
		
		int min = Math.min(l[0],r[0]);
		int max = Math.max(l[1],r[1]);
		
		return new int[] {min,max};
	}
}
