import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        HashMap<String, String> hash = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            String site = input[0];
            String password = input[1];
            hash.put(site, password);
        }
        
        for (int i = 0; i < M; i++) {
            String search = br.readLine();
            bw.write(hash.get(search) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
