package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class B1467 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		
		String remv = br.readLine();
		int[] remvnum = new int[10];
		int[] orinum = new int[10];
		for(int i = 0;i<num.length();i++) {
			char c = num.charAt(i);
			orinum[c-'0']++;
		}
		
		for(int i =0;i<remv.length();i++) {
			char c = remv.charAt(i);
			remvnum[c-'0']++;
		}
		
		
		
	}
}
