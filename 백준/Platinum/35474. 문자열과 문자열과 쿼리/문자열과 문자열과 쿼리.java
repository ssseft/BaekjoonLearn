import java.io.*;
import java.util.*;

public class Main {
	static class block{
		char c;
		int cnt;
		public block(char c, int cnt) {
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int[][] dp = new int[5001][5001];
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		max = 0;
		
		List<block> listA = new ArrayList<>();
		List<block> listB = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num==3) {
				sb.append(max).append('\n');
			}
			else {
				char c = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				if(num==1) {
					addBlock(listA,c,x);
					update(listA, listB,true);
				}
				else {
					addBlock(listB,c,x);
					update(listA, listB,false);
				}
			}
		}
		System.out.print(sb);
	}
	static void addBlock(List<block> list,char c,int x) {
	    if(!list.isEmpty() && list.get(list.size()-1).c==c){
	        list.get(list.size()-1).cnt += x;
	    }
	    else list.add(new block(c, x));
	}
	static void update(List<block> A, List<block> B, boolean updatedA) {
        if(A.isEmpty()||B.isEmpty()) return;

        if(updatedA){
            int i = A.size();
            block a = A.get(i-1);

            for(int j = 1; j<=B.size();j++) {
                block b = B.get(j-1);

                if(a.c==b.c) {
                    int mn = Math.min(a.cnt, b.cnt);
                    max = Math.max(max, dp[i - 1][j - 1] + mn);

                    if(a.cnt==b.cnt){
                        dp[i][j] = dp[i - 1][j - 1] + a.cnt;
                    } 
                    else {
                        dp[i][j] = mn;
                    }
                }
                else {
                    dp[i][j] = 0;
                }
            }
        } 
        else{
            int j = B.size();
            block b=B.get(j-1);

            for(int i = 1;i<=A.size(); i++) {
                block a = A.get(i-1);

                if(a.c==b.c){
                    int mn = Math.min(a.cnt, b.cnt);

                    max = Math.max(max,dp[i-1][j-1]+mn);
                    if(a.cnt == b.cnt) {
                        dp[i][j] = dp[i - 1][j - 1] + a.cnt;
                    } 
                    else {
                        dp[i][j] = mn;
                    }
                } 
                else{
                    dp[i][j] = 0;
                }
            }
        }
    
	}
}
