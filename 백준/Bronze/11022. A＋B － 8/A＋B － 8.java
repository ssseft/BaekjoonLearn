import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int idx = 1;
      while(t-->0) {
    	  sc.nextLine();
    	  int a = sc.nextInt();
    	  int b = sc.nextInt();
    	  int c = a+b;
    	  System.out.println("Case #"+idx+++": "+a+" + "+b+" = "+c);
      }
    }
}