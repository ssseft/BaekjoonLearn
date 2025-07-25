package beakjoon1;

public class P86971 {
	public static void main(String[] args) {
		int[][] wires = new int[][] {
			{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}
		};
		System.out.println(solution(9,wires));
	}
	static public int solution(int n, int[][] wires) {
        int answer = 9999;
        for(int i = 0;i<wires.length;i++) {
        	boolean[] include = new boolean[n+1];
        	include[1] = true;
        	int cnt = 1;
        	for(int j = 0;j<wires.length;j++) {
        		if(i!=j) {
        			int f = wires[j][0];
        			int s = wires[j][1];
        			if(include[f]&&!include[s]) {
        				cnt++;
        				include[s] = true;
        			}
        			if(include[s]&&!include[f]) {
        				cnt++;
        				include[f] = true;
        			}
        		}
        	}
        	answer = Math.min(answer, Math.abs(n-cnt*2));
        }
        
        return answer;
    }
}
