import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] nums = new boolean[10];
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i =0; i<m; i++) {
			int num = sc.nextInt();
			nums[num] = true;
		}
		sc.close();
		int count = Math.abs(100-n);
		boolean check;
		for(int i = 0; i<1000001; i++) {
			String n1 = Integer.toString(i);
			check = true;
			for(int j = 0; j<n1.length();j++) {
				int a = n1.charAt(j)-'0';
				if(nums[a]) {
					check = false;
					break;
				}
			}
			if(check) {
				count = Math.min(Math.abs(i-n)+n1.length(), count);
			}
		}
		System.out.print(count);
		
	}
}
