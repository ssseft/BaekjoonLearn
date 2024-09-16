package beakjun;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1700 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[k];
		StringTokenizer st=  new StringTokenizer(sc.next());
		for(int i =0;i<k;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean nums[] = new boolean[k+1]; //꽃혀있는 콘센트들
		int using = 0;
		for(int i = 0; i<n;i++) {
			int machine = arr[i];
			if(!nums[arr[i]]) {
				if(using<n) {
					nums[machine] = true;
					using++;
				}
				else {
					ArrayList<Integer> list = new ArrayList<>();
					for(int j = i; j<n;j++) {
						if(nums[machine]&&!list.contains(machine)) {
							list.add(machine);
						}
					}
					if(list.size()!=n) {
						for(int j = 0; j<nums.length;j++) {
							if(nums[j] && !list.contains(j)) {
								nums[j] = false;
							}
						}
					}
					
					
					
					
				}
				
				
				
				
			}
		}
		
		
		
		
		
		
		
		
		
	}
}
