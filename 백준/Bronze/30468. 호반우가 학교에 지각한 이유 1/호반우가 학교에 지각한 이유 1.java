import java.util.*;
class Main{
	public static void main(String[]a){
		Scanner c=new Scanner(System.in);
		int sum=0;
		for(int i=0;i<4;i++)sum+=c.nextInt();
		int s=c.nextInt()*4;
		System.out.print(s<sum?0:s-sum);
	}
}
