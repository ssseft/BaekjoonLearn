package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B23291{
	static int n,k;
	static int[] arr,standard,dx;
	static int[][] arr2,newarr;
	static int[] zx = {0,0,-1,1};
	static int[] zy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		standard = new int[22];
		dx = new int[22];
		//1 2 4 6 9 12 16 20 25 30 36 42 49 56 64 72 81 90 100 110 
		// 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 11 11
		
		int a = 1;
		int b = 1;
		dx[0]= 1;
		standard[0] = 0;
		for(int i = 1;i<21;i+=2) {
			standard[i] = a++*b;
			standard[i+1] = a*b++;
			dx[i] = a;
			dx[i+1] = a;
		}
		
		int cnt = 0;
		while(true) {
			fishfill();
			roll();
			flip();
			cnt++;
			if(check()) break;
		}
		
		System.out.println(cnt);
	}
	
	static void flip() {
		List<Integer> list = new ArrayList<>();
		int[][] arr4 = new int[2][n/2];
		for(int i = n/2-1;i>=0;i--) {
			list.add(arr[i]);
		}
		for(int i = n/2;i<n;i++) {
			list.add(arr[i]);
		}
		int idx = 0;
		for(int i = 0;i<2;i++) {
			for(int j= 0;j<n/2;j++) {
				arr4[i][j] = list.get(idx++);
			}
		}
		int[][] arr5 = new int[4][n/4];
		for(int i = 0;i<2;i++) {
			for(int j = 0;j<n/4;j++) {
				arr5[i][j] = arr4[1-i][n/4-1-j];
			}
		}
		for(int i = 2;i<4;i++) {
			for(int j = 0;j<n/4;j++) {
				arr5[i][j] = arr4[i-2][j+n/4];
			}
		}
		adjust(arr5);
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0;i<n/4;i++) {
			for(int j = 3;j>=0;j--) {
				list2.add(arr5[j][i]);
			}
		}
		for(int i = 0;i<n;i++) {
			arr[i] = list2.get(i);
		}
	}
	static void adjust(int[][] arr3) {
		int x = arr3.length;
		int y = arr3[0].length;
		
		int[][] adjustnum = new int[x][y];
		
		for(int i = 0;i<x;i++) {
			for(int j = 0;j<y;j++) {
				if(arr3[i][j]!=0) {
					for(int k = 0;k<4;k++) {
						int cx = i+zx[k];
						int cy = j+zy[k];
						if(cx>=0&&cy>=0&&cx<x&&cy<y&&arr3[cx][cy]!=0&&(arr3[i][j]-arr3[cx][cy])>=5) {
							int quo = (arr3[i][j]-arr3[cx][cy])/5;
							adjustnum[i][j] -= quo;
							adjustnum[cx][cy] += quo;
						}
					}
				}
			}
		}
		for(int i = 0;i<x;i++) {
			for(int j =0;j<y;j++) {
				arr3[i][j] += adjustnum[i][j];
			}
		}
	}
	static void roll() {
		arr2 = new int[1][n];
		arr2[0] = arr.clone();
		
		int idx = 1;
		while(true) {
			int x = dx[idx];
			int y = n-standard[idx];
			
			newarr = new int[x][y];
			newarr[0][0] = 0;
			
			
			for(int i = 0;i<dx[idx-1];i++) {
				for(int j = 0;j<(standard[idx]/dx[idx-1]);j++) {
					newarr[j][dx[idx-1]-1-i] = arr2[i][j];
				}
			}
			
			for(int i = 0;i<y;i++) {
				newarr[newarr.length-1][i] = arr[n-y+i];
			}
			
			
		
			arr2 = new int[x][y];
			for(int i = 0;i<x;i++) {
				arr2[i] = newarr[i].clone();
			}
			
			if(dx[idx-1]>n-standard[idx]-dx[idx]) break;
			idx++;
		}
		adjust(arr2);
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<arr2[0].length;i++) {
			for(int j = 0;j<arr2.length;j++) {
				if(arr2[arr2.length-1-j][i]!=0) {
					list.add(arr2[arr2.length-1-j][i]);
				}
			}
		}
		for(int i = 0;i<n;i++) {
			arr[i] = list.get(i);
		}
	}
	static void fishfill() {
		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++) {
			if(min>arr[i]) {
				list.clear();
				list.add(i);
				min = Math.min(min, arr[i]);
			}
			else if(min==arr[i]) {
				list.add(i);
			}
		}
		for(int c : list) {
			arr[c]++;
		}
	}
	
	static boolean check() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int a : arr) {
			if(a<min) {
				min = Math.min(min, a);
			}
			if(max<a) {
				max = Math.max(max, a);
			}
		}
		return max-min<=k ? true : false;
	}
}
