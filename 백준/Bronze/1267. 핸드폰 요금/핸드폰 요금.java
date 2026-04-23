import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int Ytotal = 0;
		int Mtotal = 0;
		for(int i = 0;i<n;i++) {
			int c = sc.nextInt();
			Ytotal += (c/30+1)*10; 
			Mtotal += (c/60+1)*15;
		}
		
		if(Ytotal==Mtotal) {
			System.out.print("Y M "+Ytotal);
		}
		else if(Ytotal>Mtotal) {
			System.out.print("M "+Mtotal);
		}
		else {
			System.out.print("Y "+Ytotal);
		}
	}
}
