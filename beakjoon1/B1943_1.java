package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1943_1 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      List<int[]> list;
      
      int t = 3;
      while(t-->0) {
         int n = Integer.parseInt(br.readLine());
         
         
         list = new ArrayList<>();
         int sum = 0;
         for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] {a,b});
            sum+= a*b;
         }
         if(sum%2==1) {
        	 sb.append(0+"\n");
        	 continue;
         }
         boolean[] dp = new boolean[sum/2+1];
         dp[0] = true;
         for(int[] coin : list) {
        	 int value = coin[0];
        	 int cnt = coin[1];
        	 int k = 1;
        	 
        	 while(cnt>0) {
        		 int use = Math.min(k, cnt);
        		 int csum = value*use;
        		 
        		 for(int j = sum/2;j>=csum;j--) {
        			 if(dp[j-csum]) dp[j] = true;
        		 }
        		 cnt-=use;
            	 k<<=1;
        	 }
         }
         
         if(dp[sum/2]) sb.append(1);
         else sb.append(0);
         
         sb.append("\n");
         
      }
      System.out.print(sb.toString().trim());
   }
}
