import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		sc.close();
		Queue<Integer> b = new LinkedList<>();
		
		for(int i =0; i<a; i++) {
			b.add(i+1);
		}
		for(int i =0; i<a-1; i++) {
			b.poll();
			int c = b.poll();
			b.add(c);
		}
		System.out.print(b.poll());
		
	}
}