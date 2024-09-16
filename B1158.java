package beakjun;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class B1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i<n+1;i++) {
			queue.offer(i);
		}
		System.out.print("<");
		for(int i = 0; i<n-1; i++) {
			for(int j = 0; j<k-1; j++) {
				int removeElement = queue.poll();
				queue.offer(removeElement);
			}
			int num = queue.poll();
			System.out.print(num +", ");
		}
		int lastElement = queue.poll();
		System.out.print(lastElement+">");
	}
}
