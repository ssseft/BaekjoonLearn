import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<t;i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			long result = 0;
			
			for(int j =0;j<n;j++) {
				arr[j] = sc.nextInt();
			}
			int maxPrice = arr[n-1];
			for(int k =n-2;k>=0;k--) {
                if (arr[k]>maxPrice) {
                    maxPrice=arr[k];
                } else {
                    result+=maxPrice-arr[k];
                }
            }

			sb.append(result+"\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}
}