import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int max;
	static List<Character> alphabet;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if(k<5) {
			System.out.print(0);
			return;
		}
		max = 0;
		
		alphabet = new ArrayList<>();
		
		for(int i = 0;i<26;i++) {
			char c = (char)(i+'a');
			alphabet.add(c);
		}

		alphabet.remove((Character)'a');
		alphabet.remove((Character)'n');
		alphabet.remove((Character)'t');
		alphabet.remove((Character)'i');
		alphabet.remove((Character)'c');

		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			String line = br.readLine();
			int bitmask = 0;
			for(int j = 0;j<line.length();j++) {
				int c = line.charAt(j)-'a';
				bitmask = bitmask|(1<<c);
			}
			list.add(bitmask);
		}
		
		
		combination(list,0,0,k-5,532741);
		
		System.out.print(max);
		
		
	}
	
	static void combination(List<Integer> list, int idx, int cnt, int targetcnt, int teachbit ) {
		if(cnt==targetcnt) {
			int able = 0;
			for(int i= 0;i<list.size();i++) {
				if((list.get(i)&teachbit)==list.get(i)) {
					able++;
				}
			}
			max = Math.max(max, able);
			return;
		}
		
		for(int i = idx;i<alphabet.size();i++) {
			char c = alphabet.get(i);
			if((teachbit&(1<<(c-'a')))==0) {
				int teached = teachbit|(1<<(c-'a'));
				combination(list, i+1, cnt+1, targetcnt, teached);
			}
		}
	}
}