import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i = 0; i<num; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int max = 0;
			Queue<int[]> q = new LinkedList<>();
			
			for(int j = 0; j<n; j++) {
				q.offer(new int[] {j,sc.nextInt()});
			}
			
			while(true) {
				int now[] = q.poll();
				boolean flag = true;
				
				for(int[] que : q) {
					if(que[1] > now[1]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					max++;
					if(now[0] == m) {
						break;
					}
				}
				else {
					q.offer(now);
				}
			}
			System.out.println(max);
		}
	}
}
