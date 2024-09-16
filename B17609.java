package beakjun;
import java.util.Scanner;

public class B17609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<t;i++) {
			String word = sc.nextLine();
			int half = word.length()/2;
			int count1 = 0;
			int count2 = 0;
			for(int j = 0; j<half;j++) {
				if(word.charAt(j+count1)!=word.charAt(word.length()-j-1-count2)) {
					if(word.charAt(j+count1+1)==word.charAt(word.length()-j-1-count2)) {
						count1++;
						if(count1+count2>1) {
							break;
						}
					}
					else if(word.charAt(j+count1)==word.charAt(word.length()-j-2-count2)) {
						count2++;
						if(count2+count1>1) {
							break;
						}
					}
					else {
						count1 =2;
						break;
					}
				}
			}
			if(count1==0&&count2==0) {
				sb.append(0+"\n");
			}
			else if(count1+count2==1) {
				sb.append(1+"\n");
			}
			else {
				sb.append(2+"\n");
			}
		}
		System.out.print(sb.toString());
	}
}
