import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line= br.readLine();
		
		int one = 0;
		int two = 0;
		int cnt = 0;
		int Bcnt = 0;
		
		for(int i = 0;i<line.length();i++) {
			if(line.charAt(i)=='A') {
				one++;
			}
			else if(line.charAt(i)=='B'&&one>0) {
				one--;
				cnt++;
			}
		}
		
		for(int i = 0;i<line.length();i++) {
			if(line.charAt(i)=='B') {
				two++;
				Bcnt++;
			}
			else if(line.charAt(i)=='C'&&two>0) {
				two--;
				cnt++;
			}
		}
		
		System.out.println(Math.min(cnt, Bcnt));
	}
}
