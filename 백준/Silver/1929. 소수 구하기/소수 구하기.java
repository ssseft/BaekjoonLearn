import java.util.Scanner;


public class Main {
	public static boolean[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		arr = new boolean[b+1];
		arr();
		
		for(int i = a; i<=b;i++) {
			
			if(!arr[i]) {
				System.out.println(i);
			}
		}

	}
	
	
	public static void arr() {
		arr[0] = arr[1] = true;
		
		for(int i = 2; i <= Math.sqrt(arr.length); i++) {
			if(arr[i]) continue;
			for(int j = i * i; j < arr.length; j += i) {
				arr[j] = true;
			}
		}
	}
}

