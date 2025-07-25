package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class B1036 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for(int i = 0;i <n;i++) {
			list.add(br.readLine());
		}
		int ch = Integer.parseInt(br.readLine());
		
		BigInteger[] arr = new BigInteger[36];
		
		for (int i=0; i<36;i++) {
            arr[i] = BigInteger.ZERO;
        }
		for(int i=0; i<36;i++) {
			int c = i;
			BigInteger value = BigInteger.ZERO;
			for(int j =0;j<n;j++) {
				for(int k = 0;k<list.get(j).length();k++) {
					if(c==cal(list.get(j).charAt(k))) {
						BigInteger power = BigInteger.valueOf(36).pow(list.get(0).length()-(j+ -1));
						value = value.add(power);
					}
				}
			}
			arr[i] = value;
		}
		
		
		
	}
	static int cal(Character num) {
		if('A'<=num) {
			return num-55;
		}
		return num-48;
	}
}	
