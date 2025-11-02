import java.util.*;

public class Main {
	static List<Integer> ans,cur;
	static int n;
	static boolean[] use;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for(int i = 0;i<t;i++) {
			n = sc.nextInt();
			ans = new ArrayList<>();
			cur = new ArrayList<>();
			use = new boolean[n+1];
			recur(1);
			sb.append(ans.size()+"\n");
			for(int j = 0;j<ans.size();j++) {
				sb.append(ans.get(j)+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	static void recur(int idx) {
		if(idx==n+1) {
			if(cur.size()>ans.size()) ans = new ArrayList<>(cur);
			return;
		}
		
		recur(idx+1);
		
		if(can(idx)) {
			cur.add(idx);
			use[idx] = true;
			recur(idx+1);
			use[idx] = false;
			cur.remove(cur.size()-1);
		}
	}
	static boolean can(int idx) {
		for(int c : cur) {
			int d = idx^c;
			if(d>=1&&d<=n&&use[d]) return false;
		}
		
		return true;
	}
}