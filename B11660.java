package beakjun;
import java.io.*;

public class B11660 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] arr = new int[n+1][n+1];
		for(int i =1;i<n+1;i++) {
			String[] nums = br.readLine().split(" ");
			for (int j=1; j <n+1; j++) {
                arr[i][j] = Integer.parseInt(nums[j-1]) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
            String[] numbers = br.readLine().split(" ");
            int x1 = Integer.parseInt(numbers[0]);
            int y1 = Integer.parseInt(numbers[1]);
            int x2 = Integer.parseInt(numbers[2]);
            int y2 = Integer.parseInt(numbers[3]);

            int result = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }
		System.out.print(sb.toString());
	}
}