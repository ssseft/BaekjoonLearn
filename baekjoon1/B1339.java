package beakjoon1;
import java.util.Arrays;
import java.util.Scanner;

public class B1339 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		for(int i = 0; i<n;i++) {
			arr[i] = sc.nextLine();
		}
		int[] alpha = new int[26];
		
		for(int i = 0; i<n;i++) {
			for(int j =0 ;j<arr[i].length();j++) {
				alpha[arr[i].charAt(j)-65] += Math.pow(10,arr[i].length() - j - 1);
			}
		}
		Arrays.sort(alpha);
		int index = 9;
        int sum =0;
        for(int i=alpha.length-1; i>=0; i--){
            if(alpha[i] == 0){
                break;
            }
            sum+= alpha[i]*index;
            index--;
        }
        System.out.println(sum);
		
		
	}
}
