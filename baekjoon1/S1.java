package beakjoon1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class S1 {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      long startTime = System.currentTimeMillis();
      for(int i = 1; i<=t;i++) {
         st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int k = Integer.parseInt(st.nextToken());
         List<Integer> list = new ArrayList<>();
         int cnt = 0;
         st = new StringTokenizer(br.readLine());
         for(int j = 0;j<n;j++) {
            list.add(Integer.parseInt(st.nextToken()));
         }
         if(!same(list)) {
            while(cnt<=1001) {
               list.add(list.get(k-1));
               list.remove(0);
               cnt++;
               if(same(list)) break;
            }
         }
         if(cnt==1002) {
            cnt=-1;
         }
         sb.append("#"+i+" "+cnt+"\n");
      }
      long endTime = System.currentTimeMillis();
      System.out.print(sb.toString().trim());
      System.out.println("\nExecution Time: " + (endTime - startTime) + " ms");
   }
   public static boolean same(List<Integer> list) { 
      int standard = list.get(0);
      for(int i = 1;i<list.size();i++) {
         if(standard!=list.get(i)) {
            return false;
         }
      }
      return true;
   }
}