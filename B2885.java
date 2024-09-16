package beakjun;
import java.util.Scanner;

public class B2885 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in)	;
		int k= sc.nextInt();
		sc.close();
		int size = k-1;
		size|=size>>1;
		size|=size>>2;
		size|=size>>4;
		size|=size>>8;
		size|=size>>16;
		size++;
		System.out.print(size+" ");
		if(size==k) {
			System.out.print(0);
			return;
		}
		int count = 0;
		while(k>0) {
			size = size/2;
			if(size<=k) {
				k -= size;
			}
			count++;
		}
		System.out.print(count);
	}
}
