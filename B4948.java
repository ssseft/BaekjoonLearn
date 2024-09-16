package beakjun;
import java.util.Scanner;
import java.util.ArrayList;

public class B4948 {
	public static boolean[] arr = new boolean[250000];
	public static ArrayList<Integer> number = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();
			if(num == 0) {
				break;
			}
			ber(num);
		}
	}
	
	public static void ber(int num) {
		arr[0] = arr[1] = true;
		if(num == 1) {
			System.out.println(1);
			return;
		}
		for(int i = 2; i<arr.length;i++) {
			if(!arr[i]) {
				for(int j = i*2; j<arr.length;j+=i){
					arr[i] = true;
				}
			}
		}
		int count = 0;
	    for(int i = num+1; i <= 2*num; i++) {
	        if(!arr[i]) count++;
	    }

	    System.out.println(count);
	}
}
