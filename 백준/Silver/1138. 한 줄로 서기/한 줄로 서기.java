import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] result = new int[n];
		for(int i =0; i<n;i++) {
			arr[i] = sc.nextInt();
			int count = 0;
			for(int j =0;i<n;j++) {
				if(result[j] == 0) {
					if(count == arr[i]) {
						result[j] = i+1;
						break;
					}
					count++;
				}
			}
			
		}
		
	
		for(int i = 0; i<n; i++) {
			System.out.print(result[i] +" ");
		}
            
	}
}