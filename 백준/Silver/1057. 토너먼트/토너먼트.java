import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		Queue<Integer> q = new ArrayDeque<>();
		Queue<Integer> q2;
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		int cnt = 1;
		
		while(q.size()>1) {
			q2 = new ArrayDeque<>();
			while(!q.isEmpty()) {
				if(q.size()==1) {
					q2.add(q.poll());
				}
				else {
					int x = q.poll();
					int y = q.poll();
					if(x==a||x==b) {
						if(y==a||y==b) {
							System.out.print(cnt);
							return;
						}
						q2.add(x);
					}
					else if(y==a||y==b) {
						if(x==a||x==b) {
							System.out.print(cnt);
							return;
						}
						q2.add(y);
					}
					else q2.add(x);
				}
			}
			q = q2;
			cnt++;
		}
		System.out.print(-1);
	}
}
