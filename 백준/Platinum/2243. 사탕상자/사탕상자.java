import java.io.*;
import java.util.*;

public class Main {
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		tree = new int[4_000_001];//넉넉하게 10^6*4
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1) {
				int num = query(1,1,1_000_000,b);
				sb.append(num+"\n");
				update(1, 1, 1_000_000, num, -1);
			}
			else {
				int c = Integer.parseInt(st.nextToken());
				update(1,1,1_000_000,b,c);
			}
		}
		
		System.out.print(sb.toString().trim());
	}
	static void update(int node, int start, int end, int index, int diff) {
	    if(index<start||index>end) {
	        return;
	    }
	    //나중에 뺄때를 고려
	    tree[node] += diff;
	    if(start==end) return;

	    int mid = (start+end)/2;
        update(node*2,start,mid,index,diff);
        update(node*2+1,mid+1,end,index,diff);
	}
	static int query(int node, int start, int end, long k) {
	    if(start == end) return start;

	    int mid=(start+end)/2;
	    if(tree[node*2]>=k) return query(node*2,start,mid,k);
	    else return query(node*2+1,mid+1,end,k-tree[node*2]);
	}
}