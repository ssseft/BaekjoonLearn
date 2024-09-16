package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[21];
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            
            int num;

            if(word.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                arr[num] = true;
            } else if(word.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                arr[num] = false;
            } else if(word.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                arr[num] = !arr[num];
            } else if(word.equals("empty")) {
                arr = new boolean[21];
            } else if(word.equals("all")) {
                for(int j = 1; j < 21; j++) {
                    arr[j] = true;
                }
            } else {
                num = Integer.parseInt(st.nextToken());
                sb.append(arr[num] ? "1\n" : "0\n");
            }
        }
        System.out.print(sb.toString());
    }
}