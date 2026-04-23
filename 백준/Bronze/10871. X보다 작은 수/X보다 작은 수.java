import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			int num = sc.nextInt();
			if(num<x) {
				q.add(num);
			}
		}
		sc.close();
		while (!q.isEmpty()) {
            System.out.print(q.poll());
            if (!q.isEmpty()) {
                System.out.print(" ");
            }
        }
	}
}
