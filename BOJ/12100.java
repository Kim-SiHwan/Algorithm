import java.util.*;

class node{
    int x;
    int y;
    int d;
    node(int x, int y ,int d){
        this.x=x;
        this.y=y;
        this.d=d;
    }
}

public class Main{

    static int n,m,k;
    static int ans=0, cnt=0;
    static int max=0, min=Integer.MAX_VALUE;
    static int arr[][];
    static boolean visit[][];
    static int dx[]= {-1,0,1,0};
    static int dy[]= {0,1,0,-1};

    public static int[][] copy(int arr[][]){
        int tmp[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                tmp[i][j]=arr[i][j];
            }
        }
        return tmp;
    }

    public static void move( int d ,int arr[][]) {

        if(d==0) {
            for(int i=1; i<=n; i++) {
                for(int j=2; j<=n; j++) {
                    if(arr[j][i]==0)continue;
                    int x=j;
                    for(int w=0; w<=n; w++) {
                        int nx= x+dx[d];
                        if(nx<1) break;

                        if(arr[nx][i]!=0) {
                            if(arr[nx][i]==arr[x][i]) {
                                if(visit[nx][i]==false) {
                                    visit[nx][i]=true;
                                    arr[nx][i]=arr[x][i]*2;
                                    arr[x][i]=0;
                                }
                            }
                            break;
                        }else {

                            arr[nx][i]=arr[x][i];
                            arr[x][i]=0;
                            x=nx;
                        }
                    }
                }
            }
        }
        else if(d==1) {
            for(int i=1; i<=n; i++) {
                for(int j=n-1; j>=1; j--) {
                    if(arr[i][j]==0)continue;
                    int y=j;
                    for(int w=0; w<=n; w++) {
                        int ny= y+dy[d];
                        if(ny>n) break;

                        if(arr[i][ny]!=0) {
                            if(arr[i][ny]==arr[i][y]) {
                                if(visit[i][ny]==false) {
                                    visit[i][ny]=true;
                                    arr[i][ny]=arr[i][y]*2;
                                    arr[i][y]=0;
                                }
                            }
                            break;
                        }else {

                            arr[i][ny]=arr[i][y];
                            arr[i][y]=0;
                            y=ny;
                        }
                    }
                }
            }
        }else if(d==2) {
            for(int i=1; i<=n; i++) {
                for(int j=n-1; j>=1; j--) {
                    if(arr[j][i]==0)continue;
                    int x=j;
                    for(int w=0; w<=n; w++) {
                        int nx= x+dx[d];
                        if(nx>n) break;

                        if(arr[nx][i]!=0) {
                            if(arr[nx][i]==arr[x][i]) {
                                if(visit[nx][i]==false) {
                                    visit[nx][i]=true;
                                    arr[nx][i]=arr[x][i]*2;
                                    arr[x][i]=0;
                                }
                            }
                            break;
                        }else {

                            arr[nx][i]=arr[x][i];
                            arr[x][i]=0;
                            x=nx;
                        }
                    }
                }
            }

        }else if(d==3) {
            for(int i=1; i<=n; i++) {
                for(int j=2; j<=n; j++) {
                    if(arr[i][j]==0)continue;
                    int y=j;
                    for(int w=0; w<=n; w++) {
                        int ny= y+dy[d];
                        if(ny<1) break;

                        if(arr[i][ny]!=0) {
                            if(arr[i][ny]==arr[i][y]) {
                                if(visit[i][ny]==false) {
                                    visit[i][ny]=true;
                                    arr[i][ny]=arr[i][y]*2;
                                    arr[i][y]=0;
                                }
                            }
                            break;
                        }else {

                            arr[i][ny]=arr[i][y];
                            arr[i][y]=0;
                            y=ny;
                        }
                    }
                }
            }
        }
    }

    public static void solve(int d, int dep,int[][] arr) {
        if(dep==5) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    max= Math.max(max, arr[i][j]);
                }
            }

            return;
        }




        for(int i=0; i<4; i++) {
            visit=new boolean[n+1][n+1];
            int copy[][] = copy(arr);
            move(i,copy);
            solve(i,dep+1,copy);
        }
    }

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        arr = new int[n+1][n+1];
        visit=new boolean[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        solve(0,0,arr);

        System.out.println(max);
    }

}
