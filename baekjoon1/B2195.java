package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2195 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        
        int score = 0;
        
        for(int i=0;i<p.length();i++) {
        	char c = p.charAt(i);
        	int maxidx = 0;
        	for(int j=0;j<s.length();j++) {
        		if(c == s.charAt(j)) {
        			int stack = 1;
        			while(j+stack<s.length()&&i+stack<p.length()) {
        				if(p.charAt(i+stack)==s.charAt(j+stack)) {
        					stack++;
        				}
        				else {
        					break;
        				}
        			}
        			maxidx = Math.max(maxidx, stack-1);
        			j+= stack-1;
        		}
        	}
        	i+=maxidx;
        	score++;
        }
        System.out.print(score);
	}
}
