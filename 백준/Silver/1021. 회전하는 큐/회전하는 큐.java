import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Deque<Integer> d = new ArrayDeque<>();
		for(int i = 1;i<=n;i++) {
			d.add(i);
		}
		int cnt = 0;
		for(int i = 0;i<m;i++) {
			int c = sc.nextInt();
			int left = 0;
			int right = 1;
			boolean l = false;
			boolean r = false;
			for(int j =0;j<n-i;j++) {
				if(d.getFirst()==c) l = true;
				if(!l) left++;
				d.addLast(d.pollFirst());
			}
			for(int j = 0;j<n-i;j++) {
				if(d.getLast()==c) r = true;
				if(!r) right++;
				d.addFirst(d.pollLast());
			}
			if(left<=right) {
				for(int j = 0;j<left;j++) d.addLast(d.pollFirst());
				d.pollFirst();
				cnt+=left;
			}
			else {
				for(int j = 0;j<right;j++) d.addFirst(d.pollLast());
				d.pollFirst();
				cnt+=right;
			}
		}
		System.out.print(cnt);
	}
}