import java.util.*;

public class Main {
    static class piece{
        int x,y,target,time;
        String Name;
        public piece(int x, int y, int target, int time, String name) {
            super();
            this.x = x;
            this.y = y;
            this.target = target;
            this.time = time;
            Name = name;
        }
    }
    static int n;
    static int[][] arr,des;
    static int[] bx={-1,1,1,-1};
    static int[] by={1,1,-1,-1};
    static int[] kx={-2,-1,1,2,2,1,-1,-2};
    static int[] ky={1,2,2,1,-1,-2,-2,-1};
    static int[] rx={-1,1,0,0};
    static int[] ry={0,0,-1,1};

    static int isBishopRoute(int x,int y,int movex,int movey) {
        for(int i = 0;i<4;i++) {
            int cx = x;
            int cy = y;
            while(true) {
                cx+=bx[i];
                cy+=by[i];
                if(cx<0||cy<0||cx>=n||cy>=n) break;
                for(int j = 0;j<8;j++) {
                    if(cx+kx[j]==movex&&cy+ky[j]==movey) return 3;
                }
            }
        }
        if (((x+y)%2)!=((movex+movey)%2)) return 0;
        for(int i = 0;i<4;i++) {
            int cx = x;
            int cy = y;
            while(cx>=0&&cy>=0&&cx<n&&cy<n) {
                cx+=bx[i];
                cy+=by[i];
                if(cx==movex&&cy==movey) return 1;
            }
        }
        return 2;
    }
    static int isRookRoute(int x,int y,int movex,int movey) {
        if(x==movex||y==movey) return 1;
        return 2;
    }
    static int isKnightRoute(int x,int y,int movex,int movey) {
        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[] {x,y});
        int time = 0;
        while(time<4) {
            int size = q.size();
            for(int i = 0;i<size;i++) {
                int[] c = q.poll();
                if(c[0]==movex&&c[1]==movey) return time;
                if(time==1) {
                    for(int k = 0;k<4;k++) {
                        int cx = x;
                        int cy = y;
                        while(cx>=0&&cy>=0&&cx<n&&cy<n) {
                            cx+=bx[k];
                            cy+=by[k];
                            if(cx<0||cy<0||cx>=n||cy>=n) break;
                            for(int j = 0;j<8;j++) {
                                if(cx+kx[j]==movex&&cy+ky[j]==movey) return 5;
                            }
                        }
                    }
                }
                for(int j = 0;j<8;j++) {
                    int cx = c[0]+kx[j];
                    int cy = c[1]+ky[j];
                    if(cx>=0&&cy>=0&&cx<n&&cy<n) {
                        q.add(new int[] {cx,cy});
                    }
                }
            }
            time++;
        }
        return 4;
    }

    static int idx(String s){
        if(s.equals("knight")) return 0;
        if(s.equals("bishop")) return 1;
        return 2;
    }
    static String nameOf(int i){
        if(i==0) return "knight";
        if(i==1) return "bishop";
        return "rook";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        int startX = 0,startY = 0;
        des = new int[n*n+2][2];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==1) {
                    startX = i;
                    startY = j;
                }
                des[arr[i][j]][0] = i;
                des[arr[i][j]][1] = j;
            }
        }
        int N = n*n;
        int INF = 1_000_000_000;
        int[][][][] min = new int[N+2][3][n][n];
        for(int t=1;t<=N+1;t++){
            for(int p=0;p<3;p++){
                for(int i=0;i<n;i++){
                    Arrays.fill(min[t][p][i], INF);
                }
            }
        }
        Queue<piece> q = new ArrayDeque<>();
        for(int p=0;p<3;p++){
            min[2][p][startX][startY]=0;
            q.add(new piece(startX,startY,2,0,nameOf(p)));
        }
        int ans = INF;
        while(!q.isEmpty()){
            piece c = q.poll();
            int p = idx(c.Name);
            int d = min[c.target][p][c.x][c.y];
            if(d < c.time) continue;
            if(c.target==N+1){
                ans = d;
                break;
            }
            int tx = des[c.target][0], ty = des[c.target][1];
            if(c.x==tx && c.y==ty){
                if(min[c.target+1][p][c.x][c.y] > d){
                    min[c.target+1][p][c.x][c.y] = d;
                    q.add(new piece(c.x,c.y,c.target+1,d,c.Name));
                }
            }
            for(int np=0; np<3; np++){
                if(np==p) continue;
                if(min[c.target][np][c.x][c.y] > d+1){
                    min[c.target][np][c.x][c.y] = d+1;
                    q.add(new piece(c.x,c.y,c.target,d+1,nameOf(np)));
                }
            }
            if(p==0){
                for(int k=0;k<8;k++){
                    int nx=c.x+kx[k], ny=c.y+ky[k];
                    if(0<=nx&&nx<n&&0<=ny&&ny<n){
                        if(min[c.target][p][nx][ny]>d+1){
                            min[c.target][p][nx][ny]=d+1;
                            q.add(new piece(nx,ny,c.target,d+1,c.Name));
                        }
                    }
                }
            } else if(p==1){
                for(int dir=0; dir<4; dir++){
                    int nx=c.x, ny=c.y;
                    while(true){
                        nx+=bx[dir]; ny+=by[dir];
                        if(nx<0||ny<0||nx>=n||ny>=n) break;
                        if(min[c.target][p][nx][ny]>d+1){
                            min[c.target][p][nx][ny]=d+1;
                            q.add(new piece(nx,ny,c.target,d+1,c.Name));
                        }
                    }
                }
            }else{
                for(int dir=0; dir<4; dir++){
                    int nx=c.x, ny=c.y;
                    while(true){
                        nx+=rx[dir]; ny+=ry[dir];
                        if(nx<0||ny<0||nx>=n||ny>=n) break;
                        if(min[c.target][p][nx][ny] > d+1){
                            min[c.target][p][nx][ny] = d+1;
                            q.add(new piece(nx,ny,c.target,d+1,c.Name));
                        }
                    }
                }
            }
        }
        System.out.print(ans);
    }
}