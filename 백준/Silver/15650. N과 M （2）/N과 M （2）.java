import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		print(0,1,list);
		System.out.print(sb.toString());
		
	}
	static void print(int cnt,int idx,List<Integer> list) {
		if(cnt==m) {
			for(int i = 0;i<m;i++) {
				sb.append(list.get(i)+" ");
			}
			sb.append("\n");
		}
		
		for(int i = idx;i<=n;i++) {
			List<Integer> list2 = new ArrayList<>(list);
			list2.add(i);
			print(cnt+1,i+1,list2);
		}
	}
}
