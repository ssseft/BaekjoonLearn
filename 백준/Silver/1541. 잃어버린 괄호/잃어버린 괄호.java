import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		String[] arr = str.split("-");
		int total = 0;
		for(int i =0; i<arr.length; i++) {
			int sum = 0;
			String[] add = arr[i].split("\\+");
			for(int j = 0; j<add.length; j++) {
				sum += Integer.parseInt(add[j]);
			}
			if(i == 0) {
				total +=sum;
			}
			else {
				total -= sum;
			}
		}
		System.out.print(total);
		sc.close();
	}
}
