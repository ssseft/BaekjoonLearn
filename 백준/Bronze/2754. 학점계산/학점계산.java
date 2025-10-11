import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String d = sc.next();
		
		if(d.equals("A+")) System.out.print(4.3);
		else if(d.equals("A0")) System.out.print(4.0);
		else if(d.equals("A-")) System.out.print(3.7);
		else if(d.equals("B+")) System.out.print(3.3);
		else if(d.equals("B0")) System.out.print(3.0);
		else if(d.equals("B-")) System.out.print(2.7);
		else if(d.equals("C+")) System.out.print(2.3);
		else if(d.equals("C0")) System.out.print(2.0);
		else if(d.equals("C-")) System.out.print(1.7);
		else if(d.equals("D+")) System.out.print(1.3);
		else if(d.equals("D0")) System.out.print(1.0);
		else if(d.equals("D-")) System.out.print(0.7);
		else System.out.print(0.0);
		
	}
}
