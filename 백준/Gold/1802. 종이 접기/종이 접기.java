import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<t;i++) {
			boolean check = true;
			String nums = br.readLine();
			int len = nums.length();
            while (len > 1) {
            	int mid = len / 2;
                for (int j = 0; j < mid; j++) {
                	if (j < mid / 2) {
                		if (j % 2 == 0 && nums.charAt(j) == nums.charAt(j + 2)) {
                            check = false;
                            break;
                        }
                    }
                    if (nums.charAt(j) == nums.charAt(len - 1 - j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    break;
                }
                len = mid;
                nums = nums.substring(0, mid);
            }
			if(check) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb.toString());
	}
}
