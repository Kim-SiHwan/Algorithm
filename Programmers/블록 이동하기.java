import java.util.*;

class node{
    int x;
    int y;
    int cnt;
    int t;
    node(int x, int y, int cnt, int t){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
        this.t=t;
    }
}
class Solution {

    public int solution(int[][] board) {
        int answer=0;
        int n= board.length;
        int arr[][]=new int[n+1][n+1];
        boolean visit[][][]=new boolean [n+1][n+1][2];
        Queue<node> q= new LinkedList<node>();
        q.add(new node(1,2,0,1));

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i+1][j+1]= board[i][j];
            }
        }
        while(!q.isEmpty()) {
            node d= q.poll();
            if(d.x==n && d.y==n) {
                answer=d.cnt;
                return answer;
            }

            if(d.t==1) {
                if(d.x-1>=1 && d.y-1>=1 && arr[d.x-1][d.y]==0 && arr[d.x-1][d.y-1]==0 && !visit[d.x-1][d.y][0]) {
                    q.add(new node(d.x-1,d.y,d.cnt+1,1));
                    visit[d.x-1][d.y][0]=true;
                }
                if(d.y+1<=n && arr[d.x][d.y+1]==0 && !visit[d.x][d.y+1][0]) {
                    q.add(new node(d.x,d.y+1,d.cnt+1,1));
                    visit[d.x][d.y+1][0]=true;
                }
                if(d.x+1<=n && d.y-1>=1 && arr[d.x+1][d.y]==0 && arr[d.x+1][d.y-1]==0 &&! visit[d.x+1][d.y][0]) {
                    q.add(new node(d.x+1,d.y,d.cnt+1,1));
                    visit[d.x+1][d.y][0]=true;
                }
                if(d.y-2>=1 && arr[d.x][d.y-2]==0 && !visit[d.x][d.y-1][0]) {
                    q.add(new node(d.x,d.y-1,d.cnt+1,1));
                    visit[d.x][d.y-1][0]=true;
                }
                if(d.x-1>=1 && d.y-1>=1 && arr[d.x-1][d.y]==0 && arr[d.x-1][d.y-1]==0 ) {
                    if(!visit[d.x][d.y][1]) {
                        q.add(new node(d.x,d.y,d.cnt+1,2));
                        visit[d.x][d.y][1]=true;
                    }
                    if(!visit[d.x][d.y-1][1]) {
                        q.add(new node(d.x,d.y-1,d.cnt+1,2));
                        visit[d.x][d.y-1][1]=true;
                    }
                }
                if(d.x+1<=n && d.y-1>=1 && arr[d.x+1][d.y]==0 && arr[d.x+1][d.y-1]==0) {
                    if(!visit[d.x+1][d.y][1]) {
                        q.add(new node(d.x+1,d.y,d.cnt+1,2));
                        visit[d.x+1][d.y][1]=true;
                    }
                    if(!visit[d.x+1][d.y-1][1]) {
                        q.add(new node(d.x+1,d.y-1,d.cnt+1,2));
                        visit[d.x+1][d.y-1][1]=true;
                    }
                }
            }else {
                if(d.x-2>=1 && arr[d.x-2][d.y]==0 && !visit[d.x-1][d.y][1]) {
                    q.add(new node(d.x-1,d.y,d.cnt+1,2));
                    visit[d.x-1][d.y][1]=true;
                }
                if(d.y+1<=n && d.x-1>=1 && arr[d.x][d.y+1]==0 && arr[d.x-1][d.y+1]==0 && !visit[d.x][d.y+1][1]) {
                    q.add(new node(d.x,d.y+1,d.cnt+1,2));
                    visit[d.x][d.y+1][1]=true;
                }
                if(d.x+1<=n && arr[d.x+1][d.y]==0 && !visit[d.x+1][d.y][1]) {
                    q.add(new node(d.x+1,d.y,d.cnt+1,2));
                    visit[d.x+1][d.y][1]=true;
                }
                if(d.y-1>=1 && d.x-1>=1 && arr[d.x][d.y-1]==0 && arr[d.x-1][d.y-1]==0 && !visit[d.x][d.y-1][1]) {
                    q.add(new node(d.x,d.y-1,d.cnt+1,2));
                    visit[d.x][d.y-1][1]=true;
                }
                if(d.y-1>=1 && d.x-1>=1 && arr[d.x][d.y-1]==0 && arr[d.x-1][d.y-1]==0) {
                    if(!visit[d.x-1][d.y][0]) {
                        q.add(new node(d.x-1,d.y,d.cnt+1,1));
                        visit[d.x-1][d.y][0]=true;
                    }
                    if(!visit[d.x][d.y][0]) {
                        q.add(new node(d.x,d.y,d.cnt+1,1));
                        visit[d.x][d.y][0]=true;
                    }
                }
                if(d.y+1<=n && d.x-1>=1 && arr[d.x][d.y+1]==0 && arr[d.x-1][d.y+1]==0 ) {
                    if(!visit[d.x][d.y+1][0]) {
                        q.add(new node(d.x,d.y+1,d.cnt+1,1));
                        visit[d.x][d.y+1][0]=true;
                    }
                    if(!visit[d.x-1][d.y+1][0]) {
                        q.add(new node(d.x-1,d.y+1,d.cnt+1,1));
                        visit[d.x-1][d.y+1][0]=true;
                    }
                }

            }



        }

        return answer;
    }
}