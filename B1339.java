package beakjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class B1339 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i = 0; i<n; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr);
		ArrayList<Character> list = new ArrayList<>();
		int length = arr[0].length();
		for(int i = 0; i<arr[0].length();i++) {
			for(int j = 0;j<n;j++) {
				if(length>arr[j].length()) {
					break;
				}
				if(!list.contains(arr[j].charAt(i))) {
					list.add(arr[j].charAt(i));
				}
			}
			length--;
		}
		for(String i :arr) {
			System.out.println(i);
		}
//		for(char a : list) {
//			System.out.print(a);
//		}
		
		
		for(int i = 0;i <n;i++) {
			String alpha = arr[i];
			for(int j =0; j<alpha.length();j++) {
				
				
				
			}
		}
		
		
		
	}
}
