import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		List<Integer>[] alp = new ArrayList[26];
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<26;i++) {
			alp[i] = new ArrayList<>();
		}
		for(int i = 0;i<t;i++) {
			String l = sc.nextLine();
			int k = Integer.parseInt(sc.nextLine());
			for(int j = 0;j<26;j++) alp[j].clear();
			
			for(int j = 0;j<l.length();j++) {
				char c = l.charAt(j);
				alp[c-'a'].add(j);
			}
			
			int max = -1;
			int min = 99999;
			
			for(int j = 0;j<26;j++) {
				if(alp[j].size()<k) continue;
				int left = 0;
				int right = k-1;
				while(right<alp[j].size()) {
					int c = alp[j].get(right++)-alp[j].get(left++)+1;
					min = Math.min(min, c);
					max = Math.max(max, c);
				}
			}
			if(max==-1) sb.append(-1+"\n");
			else sb.append(min+" "+max+"\n");
		}
		System.out.print(sb);
	}
}
