package beakjun;
import java.util.Scanner;

public class B1459 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		long y = sc.nextInt();
		long w = sc.nextInt(); // x,y������ ��ĭ �̵��ϴµ� �Ҹ�Ǵ� ���
		long s = sc.nextInt(); // +x,+y||-x+y||+x-y�ϴµ� �Ҹ�Ǵ� ���
		long distance = x+y;
		long result = 0;
		boolean check = false;
		if(distance%2==1) {
			check =true;
		}
		if(s<=w) {
			if(check) {
				result =Math.min(x, y)*s+(Math.abs(x-y)/2)*2*s+w;
			}
			else {
				result =Math.min(x, y)*s+(Math.abs(x-y))*s;
			}
		}
		else if(w<s&&s<=2*w){
			result = s*Math.min(x, y)+ Math.abs(x-y)*w;
		}
		else {
			result = distance*w;
		}
		System.out.print(result);
		sc.close();
	}
}