import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node {
    int x;
    int y;
    int d;
    node (int x, int y,int d){
        this.x=x;
        this.y=y;
        this.d=d;
    }

}


public class Main {

    static int n,m;
    static int cnt=0,ans=0;
    static int dx[]= {-1,0,1,0};
    static int dy[]= {0,1,0,-1};

    static int arr[][];
    static int x,y,d;

    public static void print() {
        System.out.println();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String arg[]) {

        Scanner sc = new Scanner(System.in);

        n= sc.nextInt();
        m= sc.nextInt();
        x= sc.nextInt();
        y= sc.nextInt();
        d= sc.nextInt();

        node cleaner = new node(x,y,d);

        arr = new int [n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j]= sc.nextInt();
            }
        }

        while(true) {
            arr[cleaner.x][cleaner.y]=5;

            int nd = (cleaner.d+3)%4;
            int nx= cleaner.x + dx[nd];
            int ny= cleaner.y + dy[nd];
            if(nx>=0 && ny>=0 && nx<n && ny<m) {

                if(arr[nx][ny]==0) {
                    cleaner.x=nx;
                    cleaner.y=ny;
                    cleaner.d=nd;
                    cnt=0;
                }else {
                    cnt++;
                    cleaner.d=nd;
                }
            }
            if(cnt==4) {
                cnt=0;
                int cd = (cleaner.d +2 )%4;
                if(arr[cleaner.x+dx[cd]][cleaner.y+dy[cd]] == 1)
                    break;
                cleaner.x= cleaner.x+dx[cd];
                cleaner.y= cleaner.y+dy[cd];
            }

        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j]==5) {
                    ans++;
                }
            }
        }
        System.out.println(ans);


    }
}