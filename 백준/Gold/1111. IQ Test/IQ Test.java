import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i =0;i <n; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(n == 1) {
			System.out.print("A");
		}
		
		else if(n == 2) {
			if(arr[0] == arr[1]) {
				System.out.print(arr[0]);
			}
			else {
				System.out.print("A");
			}
		}
		else {
			
			if(arr[1]-arr[0] ==0) {
				boolean allsame= true;
				for(int i =2;i<n;i++) {
					if(arr[i] != arr[0]) {
						allsame = false;
						break;
					}
				}
				if(allsame) {
					System.out.print(arr[0]);
				}
				else {
					System.out.print("B");
				}
			}
			else {
				double a = (arr[2]-arr[1])/(arr[1]-arr[0]);
				double b = arr[1] - a*arr[0];
				
				int a1 = (int) a;
				String result = null;
				boolean check = false;
				
				if(a1 != a) {
					result = "B";
					check = true;
				}
				
				int b1 = (int)b;
				for(int i = 2; i<n;i++) {
					if(arr[i] != arr[i-1]*a1+b1) {
						result = "B";
						check = true;
					}
				}
				
				if(!check) {
					result = String.valueOf(arr[n-1]*a1+b1);
				}
				
				System.out.print(result);
			}
		}
	}
}