package beakjoon1;

public class P43105 {
	public static void main(String[] args) {
		int[][] t = new int[][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(solution(t));
	}
	static public int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 1;i<triangle.length;i++) {
        	for(int j = 0;j<triangle[i].length;j++) {
        		if(j==0) {
        			triangle[i][j] += triangle[i-1][j];
        		}
        		else if(j==triangle[i].length-1) {
        			triangle[i][j] += triangle[i-1][j-1];
        		}
        		else {
        			triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
        		}
        	}
        }
        for(int i = 0;i<triangle[triangle.length-1].length;i++) {
        	answer = Math.max(answer, triangle[triangle.length-1][i]);
        }
        
        return answer;
	}
}
