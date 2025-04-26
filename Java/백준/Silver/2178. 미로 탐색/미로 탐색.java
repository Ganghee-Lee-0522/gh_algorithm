import java.util.*;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int[][] cnt;
    static int N, M;
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    
	    board = new int[N][M];
	    cnt = new int[N][M];
	    
	    for(int i = 0; i < N; i++) {
	        String s = sc.next();
	        for(int j = 0; j < M; j++) {
	            board[i][j] = s.charAt(j) - '0';
	        }
	    }
	    
	    cnt[0][0] = 1;
	    Queue<Pair> q = new LinkedList<>();
	    q.offer(new Pair(0, 0));
	    
	    while(!q.isEmpty()) {
	        Pair cur = q.poll();
	        for(int dir = 0; dir < 4; dir++) {
	            int nx = cur.x + dx[dir];
	            int ny = cur.y + dy[dir];
	            
	            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
	                continue;
	            }
	            if(board[nx][ny] == 0 || cnt[nx][ny] > 0) {
	                continue;
	            }
	            if(nx == N - 1 && ny == M - 1) {
	                System.out.print(cnt[cur.x][cur.y] + 1);
	            }
	            
	            cnt[nx][ny] = cnt[cur.x][cur.y] + 1;
	            q.offer(new Pair(nx, ny));
	        }
	    }
	    
	    return;
	}
}