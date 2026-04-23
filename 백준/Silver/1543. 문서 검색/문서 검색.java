import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		String search = sc.nextLine();
		
		int a = word.length();
		int b = search.length();
		
		word = word.replace(search,"");
		
		int result = ((a-word.length())/b);
		
		System.out.println(result);
	}
}
