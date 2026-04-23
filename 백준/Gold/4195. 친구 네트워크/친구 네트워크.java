import java.util.*;

public class Main {
	static int union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if(a1==b1) return cnt[a1];
		if(a1<b1) {
			int t = a1;
			a1 = b1;
			b1=  t;
		}
		parent[b1] = a1;
		cnt[a1]+= cnt[b1];
		return cnt[a1];
	}
	static int find(int x) {
		if(x==parent[x]) return x;
		else return find(parent[x]);
	}
	
	static int[] parent; 
	static int[] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<t;i++) {
			int idx = 1;
			int n = sc.nextInt();
			parent = new int[200022];
			cnt = new int[200022];
			Map<String,Integer> map = new HashMap<>();
			for(int j = 1;j<=200022;j++) {
				parent[i] = i;
			}
			for(int j = 0;j<n;j++) {
				String a = sc.next();
				String b = sc.next();
				if(!map.containsKey(a)) {
					map.put(a, idx);
					parent[idx] = idx;
					cnt[idx]= 1;
					idx++;
				}
				if(!map.containsKey(b)) {
					map.put(b, idx);
					parent[idx] = idx;
					cnt[idx]= 1;
					idx++;
				}
				int ans = union(map.get(a),map.get(b));
				sb.append(ans+"\n");
			}
		}
		System.out.print(sb);
	}
}
