import java.util.*;
class Main{
	public static void main(String[] a) {
		Scanner c=new Scanner(System.in);
		int n=c.nextInt();
		int sum=0;
		for(int i=0;i<n;i++)sum+=c.nextInt();
		System.out.print(sum-n+1);
	}
}