package beakjoon1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2 {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      
      for(int i = 1;i<=t;i++) {
         st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int k = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         int[] arr = new int[n];
         for(int j = 0; j<n;j++) {
            arr[j] = Integer.parseInt(st.nextToken());
         }
         int max = Integer.MIN_VALUE;
         int sum;
         for(int a = 0; a <= n-2*k;a++) {
            sum = 0;
            for(int f = a;f<a+k;f++) {
               sum+= arr[f];
            }
            int first_value = sum;
            for(int b= a+k;b<=n-k;b++) {
               sum = first_value;
               for(int g = b;g<b+k;g++) {
                  sum+= arr[g];
               }
               if(sum>max) {
                  max = sum;
               }
            }
         }
         sb.append("#"+i+" "+max+"\n");
      }
      System.out.print(sb.toString().trim());
   }
}
