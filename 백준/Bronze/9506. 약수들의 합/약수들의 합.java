import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int a = sc.nextInt();
			if(a==-1) break;
			List<Integer> list = new ArrayList<>();
			for(int i = 1;i<a;i++) 
				if(a%i==0) list.add(i);
			int sum = 0;
			for(int c : list) 
				sum += c;
			sb.append(a+" ");
			if(sum==a) {
				sb.append("= ");
				for(int i = 0;i<list.size()-1;i++) {
					sb.append(list.get(i)+" + ");
				}
				sb.append(list.get(list.size()-1));
			}
			else sb.append("is NOT perfect.");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
