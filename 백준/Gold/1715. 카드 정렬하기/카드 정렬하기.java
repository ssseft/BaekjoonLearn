import java.util.Scanner;
import java.util.PriorityQueue;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i =0; i<n;i++) {
			q.offer(sc.nextInt());
		}
		sc.close();
		int sum = 0;
		while(q.size()!=1) {
			int a = q.poll();
			int b = q.poll();
			sum += a+b;
			q.add(a+b);
		}
		
		System.out.print(sum);
	}
}
