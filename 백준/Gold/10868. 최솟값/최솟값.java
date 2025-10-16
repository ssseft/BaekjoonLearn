import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr,tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		tree = new int[n*4];
		Arrays.fill(tree, Integer.MAX_VALUE);
		
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		create(1,0,n-1);
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(cal(1,0,n-1,a-1,b-1)+"\n");
		}
		
		System.out.print(sb.toString().trim());
	}
	static void create(int node,int start,int end) {
		if(start==end) {
			tree[node] = arr[start];
		}
		else {
			int mid = (start+end)/2;
			create(2*node,start,mid);
			create(2*node+1,mid+1,end);
			tree[node] = Math.min(tree[2*node], tree[2*node+1]);
		}
	}
	static int cal(int node,int start, int end, int left, int right) {
		if(left>end||right<start) {
			return Integer.MAX_VALUE;
		}
		if(left<=start&&end<=right) {
			return tree[node];
		}
		int mid = (start+end)/2;
		int l = cal(node*2,start,mid,left,right);
		int r = cal(node*2+1,mid+1,end,left,right);
		return Math.min(l, r);
	}
}
