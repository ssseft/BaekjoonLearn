import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n];
		com(n,m,0,1);
		
		sc.close();
		
		
		
		
		
		
	}
	
	public static void com(int n, int m,int des,int start) {
		if(des == m) {
			for(int i : arr) {
				if(i ==0) {
					break;
				}
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i =start; i<=n;i++) {
			arr[des] = i;
			com(n,m,des+1,i);
		}
	}
	
}