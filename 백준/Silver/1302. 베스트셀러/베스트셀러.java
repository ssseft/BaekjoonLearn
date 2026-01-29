import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String ans = "";
		List<String> list = new ArrayList<>();
		int[] cnt = new int[n];
		for(int i = 0;i<n;i++) {
			String word = sc.nextLine();
			boolean ch = false;
			for(int j = 0;j<list.size();j++) {
				if(list.get(j).equals(word)) {
					cnt[j]++;
					ch = true;
					break;
				}
			}
			if(!ch) {
				list.add(word);
				cnt[list.size()-1]++;
			}
		}
		int max = -1;
		for(int i = 0;i<list.size();i++) {
			String c = list.get(i);
			if(cnt[i]==max) {
				ans = (ans.compareTo(c) <= 0) ? ans : c;
			}
			else if(cnt[i]>max) {
				ans = c;
				max = cnt[i];
			}
		}
		System.out.print(ans);
	}
}