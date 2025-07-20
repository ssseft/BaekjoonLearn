package beakjoon1;

public class P42898 {
	public static void main(String[] args) {
		System.out.println(solution(4,3,new int[][] {{1,2}}));
	}
	static public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n][m];
        for(int i = 0;i<puddles.length;i++) {
        	int[] d = puddles[i];
        	arr[d[1]][d[0]] = -1;
        }
        arr[0][0] = 1;
        for(int i = 1;i<m;i++) {
        	if(arr[0][i]==-1) break;
        	arr[0][i] = 1;
        }
        for(int i = 1;i<n;i++) {
        	if(arr[i][0]==-1) break;
        	arr[i][0] = 1;
        }
        for(int i = 1;i<n;i++) {
        	for(int j = 1;j<m;j++) {
        		int left = arr[i][j-1];
        		int up = arr[i-1][j];
        		if(arr[i][j]==-1||(left==-1&&up==-1)) continue;
        		
        		arr[i][j] = (arr[i-1][j]+arr[i][j-1])%1000000007;
        		
        		if(left==-1||up==-1) arr[i][j]++;
        	}
        }
        answer = arr[n-1][m-1];
        
        return answer;
    }
}
