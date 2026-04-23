import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String nums = sc.next();
		sc.close();
		sb.append(nums);
		Character[] arr = new Character[nums.length()];
		int sum = 0;
		boolean check = false;
		for(int i = 0; i<nums.length(); i++) {
			arr[i] = nums.charAt(i);
			sum += arr[i];
			if(arr[i] == '0') {
				check = true;
			}
		}
		Arrays.sort(arr,Collections.reverseOrder());
		if(!check || sum % 3!=0) {
			System.out.print(-1);
		}
		else {
			for(Character str : arr) {
				System.out.print(str);
			}
		}
	}
}