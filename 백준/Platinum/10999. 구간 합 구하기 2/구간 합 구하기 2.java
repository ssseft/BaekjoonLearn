import java.io.*;
import java.util.*;

public class Main{
	static class SegmentTree{
		long tree[];
		long[] lazy;
		
		public SegmentTree(long[] tree, long[] lazy) {
			this.tree = tree;
			this.lazy = lazy;
		}
		
		public long init(long[] arr, int node, int start,int end) {
			if(start==end) {
				return tree[node] = arr[start];
			}
			
			return tree[node] = init(arr,node*2,start,(start+end)/2)
					+ init(arr,node*2+1,(start+end)/2+1,end);
		}
		
		public void propagate(int node, int start, int end) {
			if(lazy[node]!=0) {
				tree[node] += (end-start+1)*lazy[node];
				if(start<end) {
					lazy[node*2] += lazy[node];
					lazy[node*2+1] += lazy[node];
				}
				lazy[node] = 0;
			}
		}
		
		public void update(int node,int start,int end,int left,int right,long diff) {
			propagate(node,start,end);
			if(left<=start&&right>=end) {
				lazy[node] += diff;
				propagate(node,start,end);
			}
			else if(!(start>right||end<left)) {
				update(node*2,start,(start+end)/2,left,right,diff);
				update(node*2+1,(start+end)/2+1,end,left,right,diff);
				tree[node] = tree[node*2]+tree[node*2+1];
			}
		}
		
		public long sum(int node, int start, int end, int left, int right) {
			propagate(node,start,end);
			if(left>end||right<start) {
				return 0;
			}
			
			if(left<=start&& end<=right) {
				return tree[node];
			}
			else {
				return sum(node*2,start,(start+end)/2,left,right)+
						sum(node*2+1,(start+end)/2+1,end,left,right);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		long[] arr = new long[n+1];
		for(int i = 1;i<=n;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		long[] tree = new long[4*n];
		long[] lazy = new long[4*n];
		
		SegmentTree s = new SegmentTree(tree,lazy);
		s.init(arr, 1, 1, n);
		
		for(int i = 0;i<m+k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				s.update(1,1,n,b,c,d);
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(s.sum(1, 1, n, b, c)+"\n");
			}
		}
		System.out.print(sb);
	}
}