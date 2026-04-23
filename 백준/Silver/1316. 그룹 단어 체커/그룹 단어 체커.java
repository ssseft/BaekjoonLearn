import java.util.Scanner;

public class Main {
	public static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		count = 0;
		String[] arr = new String[n];
		for(int i =0; i<n; i++) {
			if(Groupwordchecker(sc.next())){
				count++;
			}
		}
		
		System.out.print(count);
		
		
	}
	
	public static boolean Groupwordchecker(String a) {
		boolean[] visited = new boolean[26];
		int b = 0;
		for(int i =0; i<a.length(); i++) {
			int letter = a.charAt(i);
			if(visited[letter - 'a']&& b != letter) {
				return false;
			}
			visited[letter - 'a'] = true;
			b = letter;
		}
		return true;
	}
	
}