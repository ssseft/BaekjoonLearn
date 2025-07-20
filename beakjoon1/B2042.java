package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		for(int i = 0;i<n;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		long[] tree = new long[n*4];
		createtree(tree,arr,1,0,n-1);
		StringBuilder sb = new StringBuilder();
		for(long a : tree) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		for(int i = 0;i<m+k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				long c = Long.parseLong(st.nextToken());
				update(tree,arr,1,0,n-1,b-1,c);
			}
			else {
				int c = Integer.parseInt(st.nextToken());
				sb.append(query(tree,1,0,n-1,b-1,c-1)+"\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
	static void createtree(long[] tree,long[] arr, int node, int start, int end) {
		if(start==end) {
			tree[node] = arr[start];
		}
		else {
			int mid = (start+end)/2;
			createtree(tree, arr,2*node,start,mid);
			createtree(tree, arr,2*node+1,mid+1,end);
			tree[node]=tree[2*node]+tree[2*node+1];
		}
	}
	static long query(long[] tree,int node,int start, int end,int left,int right) {
		if(left>end||right<start) {
			return 0;
		}
		if(left<=start&&end<=right) {
			return tree[node];
		}
		int mid = (start+end)/2;
		long lsum = query(tree,node*2,start,mid,left,right);
		long rsum = query(tree,node*2+1,mid+1,end,left,right);
		return lsum+rsum;
	}
	static void update(long[] tree,long[] arr,int node,int start,int end,int idx, long value) {
		if(idx<start||idx>end) {
			return;
		}
		if(start==end) {//리프 노드일 때
			arr[idx] = value;
			tree[node] = value;
			return;
		}
		int mid = (start+end)/2;
		update(tree,arr,node*2,start,mid,idx,value);
		update(tree,arr,node*2+1,mid+1,end,idx,value);
		tree[node] = tree[node*2]+tree[node*2+1];
	}
}
