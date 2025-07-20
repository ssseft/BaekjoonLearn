package beakjoon1;

import java.util.LinkedList;
import java.util.Queue;

public class P1 {
	public static void main(String[] args) {
		System.out.print(solution("hit","cog",new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	static public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        boolean[] visited = new boolean[words.length];
        boolean search = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String c = q.poll();
                if(c.equals(target)) {
                	search = true;
                	break;
                }
                for(int j = 0;j<words.length;j++) {
                	String s = words[j];
                	if(!visited[j]) {
                		int t = 0;
                		for(int k = 0;k<c.length();k++) {
                			if(c.charAt(k)!=s.charAt(k)) t++;
                		}
                		if(t==1) {
                			q.add(s);
                			visited[j] = true;
                			System.out.println(s);
                		}
                	}
                }
            }
            if(search) break;
            answer++;
        }
        
        if(!search) return 0;
        return answer;
    }
}
