package beakjun;
import java.io.*;
import java.util.StringTokenizer;

public class B6064 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int result = -1;
			boolean check = false;
			
			
			int M1 = M;
			int N1 = N;
			while (N1 != 0) {
	            int temp = N1;
	            N1 = M1 % N1;
	            M1 = temp;
	        }
	        int gcd = M1;
	        int lcm = N/ gcd;

	        for (int j = 0; j< lcm; j++) {
                int currentX = j * M + x;
                if ((currentX - 1) % N + 1 == y) {
                    result = currentX;
                    check = true;
                    break;
                }
            }
			
			if (!check) {
                sb.append(-1+"\n");
            } else {
                sb.append(result+"\n");
            }
		}
		System.out.print(sb.toString());
	}
}
