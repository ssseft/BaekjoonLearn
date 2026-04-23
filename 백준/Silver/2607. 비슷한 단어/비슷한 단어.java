import java.io.*;

public class  Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String standard = br.readLine();
		int[] alp = new int[26];
		for(int i = 0;i<standard.length();i++) {
			int c = standard.charAt(i)-'A';
			alp[c]++;
		}
		int[] alp2;
		int answer = 0;
		while(n---1>0) {
			String r = br.readLine();
			if(Math.abs(r.length()-standard.length())>1) continue;
			alp2 = new int[26];
			for(int i = 0;i<r.length();i++) {
				char c = r.charAt(i);
				alp2[c-'A']++;
			}
			
			int cnt = 0;
			for(int i = 0;i<26;i++) {
				cnt+=Math.abs(alp[i]-alp2[i]);
			}
			if(standard.length()==r.length()) {
				if(cnt!=2&&cnt!=0) continue;
			}
			else {
				if(cnt!=1) continue;
			}
			answer++;
		}
		System.out.print(answer);
	}
}