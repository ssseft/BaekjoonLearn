import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int w = sc.nextInt();
		sc.nextLine();
		String a = sc.nextLine();
		int[] arr = new int[] {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		int[] cnt = new int[] {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,4,1,2,3,1,2,3,4};
		int total = 0;
		int last = -1;
		for(int i =0;i<a.length();i++) {
			char c = a.charAt(i);
			if(c==' ') {
				total += p;
				last = 1;
			}
			else {
				if(last==arr[c-'A']) total+=w;
				total += cnt[c-'A']*p;
				last = arr[c-'A'];
			}
		}
		System.out.print(total);
	}
}