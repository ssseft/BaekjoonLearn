package beakjoon1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class B21608 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static PriorityQueue<int[]> q;
	public static void main(String[] args) throws  IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] result = new int[n][n];
		StringTokenizer st;
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i<n*n;i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[5];
			for(int j=0;j<5;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			list.add(arr);
		}
		q = new PriorityQueue<int[]>((a,b) ->{
			if(a[2]!=b[2]) {
				return b[2] - a[2];
			}
			else if(a[3]!=b[3]) {
				return b[3] - a[3];
			}
			else if(a[0]!=b[0]) {
				return a[0]-b[0];
			}
			else {
				return a[1]-b[1];
			}
		});
		for(int i = 0; i<n*n;i++) {
			cal(n,result,i,list);
			int[] c= q.poll();
			result[c[0]][c[1]] = list.get(i)[0];
			q.clear();
		}
		int score = calculateScore(n, result, list);
		System.out.print(score);
	}
	
	public static void cal(int n,int[][] result,int index,List<int[]> list) {
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<n;j++) {
				if(result[i][j]!=0) {
					continue;
				}
				int blank =0;
				int injec = 0;
				for(int k = 0; k<4;k++) {
					int cx = i+dx[k];
					int cy = j+dy[k];
					if(cx>=0&&cy>=0&&cx<n&&cy<n) {
						if(result[cx][cy]==0) {
							blank++;
						}
						for(int a=1;a<5;a++) {
							if(list.get(index)[a]==result[cx][cy]){
								injec++;
								break;
							}
						}
					}
				}
				q.add(new int[]{i,j,injec,blank});
			}
		}
		
	}
	
	public static int calculateScore(int n, int[][] result, List<int[]> list) {
	    int totalScore = 0;
	    for (int i=0; i<n;i++) {
	        for (int j=0;j<n;j++) {
	            int current = result[i][j];
	            int likeCount = 0;
	            int[] preferences = null;
	            for (int[] arr : list) {
	                if (arr[0] == current) {
	                    preferences = arr;
	                    break;
	                }
	            }
	            if (preferences == null) continue;
	            
	            for (int k = 0; k < 4; k++) {
	                int cx = i + dx[k];
	                int cy = j + dy[k];
	                if (cx>=0&&cy>=0&&cx<n&&cy<n) {
	                    for (int a =1;a<5;a++) {
	                        if (result[cx][cy]==preferences[a]) {
	                            likeCount++;
	                            break;
	                        }
	                    }
	                }
	            }
	            if (likeCount == 1) {
	                totalScore += 1;
	            } else if (likeCount == 2) {
	                totalScore += 10;
	            } else if (likeCount == 3) {
	                totalScore += 100;
	            } else if (likeCount == 4) {
	                totalScore += 1000;
	            }
	        }
	    }
	    return totalScore;
	}
}
