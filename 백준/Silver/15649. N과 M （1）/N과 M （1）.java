import java.util.*;

public class Main {
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		boolean[] use = new boolean[n+1];
		print(0,list,use);
		
		System.out.print(sb.toString());
	}
	static void print(int cnt,List<Integer> list,boolean[] use) {
		if(cnt==m) {
			for(int i = 0;i<m;i++) {
				sb.append(list.get(i)+" ");
			}
			sb.append("\n");
		}
		
		for(int i = 1;i<=n;i++) {
			if(!use[i]) {
				List<Integer> list2 = new ArrayList<>(list);
				list2.add(i);
				use[i] = true;
				print(cnt+1,list2,use);
				use[i] = false;
			}
		}
	}
}
