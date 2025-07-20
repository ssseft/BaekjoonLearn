package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1943 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      
      int t = 3;
      while(t-->0) {
         int n = Integer.parseInt(br.readLine());
         
         
         List<int[]> list = new ArrayList<>();
         int sum = 0;
         for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] {a,b});
            sum+= a*b;
         }
         
         
         
      }
      
      
   }
   static void cal() {
      
      
   }
}
