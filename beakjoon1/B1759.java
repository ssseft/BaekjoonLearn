package beakjoon1;
import java.util.Arrays;
import java.util.Scanner;

public class B1759 {
	static int consonant;
	static int vowel;
	static int length;
	static int kind;
	static int[] arr;
	static boolean[] in;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		kind = sc.nextInt();
		sc.nextLine();
		arr = new int[kind];
		for(int i = 0; i<kind;i++) {
			String a = sc.next();
			char al = a.charAt(0);
			arr[i] = (int)al-96;
		}
		sc.close();
		Arrays.sort(arr);
		in = new boolean[kind];
		sb = new StringBuilder();
		search(0,0);
		System.out.print(sb.toString().trim());
		//1,5,9,15,21 모음
		
	}
	public static void search(int start,int size) {
		if(size==length) {
			if(vowel>=1&&consonant>=2) {
				for(int i =0; i<kind;i++) {
					if(in[i]) {
						sb.append((char)(arr[i]+96));
					}
				}
				sb.append("\n");
			}
			else {
				return;
			}
		}
		for(int i = start;i<kind;i++) {
			in[i] = true;
			if(arr[i]==1||arr[i]==5||arr[i]==9||arr[i]==15||arr[i]==21) {
				vowel++;
			}
			else {
				consonant++;
			}
			search(i+1,size+1);
			in[i] = false;
			if(arr[i]==1||arr[i]==5||arr[i]==9||arr[i]==15||arr[i]==21) {
				vowel--;
			}
			else {
				consonant--;
			}
		}
	}
}
