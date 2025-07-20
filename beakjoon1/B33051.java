package beakjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B33051 {
	static int k;
	static int m;
	static int[] score;
	static int[][] ranking;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		score = new int[5];
		ranking = new int[5][5];
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int fir = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			int thi = Integer.parseInt(st.nextToken());
			int fou = Integer.parseInt(st.nextToken());
			
			int sco1 = Integer.parseInt(st.nextToken());
			int sco2 = Integer.parseInt(st.nextToken());
			int sco3 = Integer.parseInt(st.nextToken());
			int sco4 = Integer.parseInt(st.nextToken());
			
			score[fir] += sco1;
			score[sec] += sco2;
			score[thi] += sco3;
			score[fou] += sco4;
			
			ranking[fir][1]++;
			ranking[sec][2]++;
			ranking[thi][3]++;
			ranking[fou][4]++;
		}
		
		for(int d1 = 100;d1>=0;d1--) {
			for(int d2 = d1;d2>=-100;d2--) {
				for(int d3 = d2;d3>=-100;d3--) {
					int d4 = -(d1+d2+d3);
                    if (d4>=-100&&d4<=d3) {
                        if (check(d1, d2, d3, d4)) {
                            System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);
                            return;
                        }
                    }
				}
			}
		}
		System.out.print(-1);
	}
	static boolean check(int d1,int d2,int d3,int d4) {
		int tempScore[] = score.clone();
		for(int i = 1;i<5;i++) {
			tempScore[i] += ranking[i][1]*d1;
			tempScore[i] += ranking[i][2]*d2;
			tempScore[i] += ranking[i][3]*d3;
			tempScore[i] += ranking[i][4]*d4;
		}
		
		 
		int[] ranks = new int[5];

        for (int i = 1; i < 5; i++) {
            int rank = 1;
            for (int j = 1; j < 5; j++) {
                if (tempScore[j]>tempScore[i]||(tempScore[j]==tempScore[i]&&j<i)) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        
        return ranks[k]==m;
	}
}