package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {
	public static boolean cal(int left, int right, String word) {
		while(left<=right) {
			if(word.charAt(left)==word.charAt(right)) {
				left++;
				right--;
			}
			else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<t;i++) {
			String word = br.readLine();
			int left = 0;
			int right = word.length()-1;
			boolean similer = false;
			boolean no = false;
			
			while(left<=right&&!no) {
				if(word.charAt(left)== word.charAt(right)) {
					left++;
					right--;
				}
				else {
					if(cal(left+1,right,word)) {
						similer = true;
					}
					else if(cal(left,right-1,word)) {
						similer = true;
					}
					else {
						no = true;
					}
					break;
				}
			}
			
			if(no) {
				sb.append(2+"\n");
			}
			else {
				if(similer) {
					sb.append(1+"\n");
				}
				else {
					sb.append(0+"\n");
				}
			}
			
			
		}
		System.out.print(sb.toString().trim());
	}
}