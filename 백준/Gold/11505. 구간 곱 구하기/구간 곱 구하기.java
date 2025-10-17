import java.io.*;
import java.util.*;

public class Main {
	static long[] arr,tree;
	static int n;
	static long mod = 1_000_000_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		tree = new long[n*4];
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		create(1,0,n-1);
		
		for(int i = 0;i<m+k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1) {
				update(1,0,n-1,b-1,c);
			}
			else {
				sb.append(cal(1,0,n-1,b-1,c-1)+"\n");
			}
		}
		System.out.print(sb);
		
	}
	static long cal(int node,int start,int end, int left, int right) {
		if(left>end||right<start) {
			return 1;
		}
		if(left<=start&&end<=right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		long lsum = cal(node*2,start,mid,left,right);
		long rsum = cal(node*2+1,mid+1,end,left,right);
		return (lsum*rsum)%mod;
	}
	static void create(int node,int start,int end) {
		if(start==end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		create(2*node,start,mid);
		create(2*node+1,mid+1,end);
		tree[node] = (tree[2*node]*tree[2*node+1])%mod;
	}
	static void update(int node,int start,int end, int idx,long value) {
		if(idx<start||idx>end) return;
		if(start==end) {
			arr[idx] = value;
			tree[node] = value;
			return;
		}
		int mid = (start+end)/2;
		update(node*2,start,mid,idx,value);
		update(node*2+1,mid+1,end,idx,value);
		tree[node] = (tree[node*2]*tree[node*2+1])%mod;
	}
}
