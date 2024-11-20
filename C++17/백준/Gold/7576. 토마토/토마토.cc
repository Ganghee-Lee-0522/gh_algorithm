#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int board[1002][1002];
int dist[1002][1002];
int m, n;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    queue<pair<int, int>> q;
    
    cin >> m >> n;
    for (int i = 0; i < n ; i++) {
        for(int j = 0; j < m; j++) {
            cin >> board[i][j];
            if(board[i][j] == 1) {
                dist[i][j] = 0;
                q.push({i, j});
            }
            else {
                dist[i][j] = -1;
            }
        }
    }
    
    while(!q.empty()) {
        pair<int, int> cur = q.front(); q.pop();
        
        for(int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(dist[nx][ny] >= 0 || board[nx][ny] == -1) continue;
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            q.push({nx, ny});
        }
    }
    int tmp = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(board[i][j] == 0 && dist[i][j] == -1) {
                cout << -1;
                return 0;
            }
            else{
                tmp = max(tmp, dist[i][j]);
            }
        }
    }
    cout << tmp;
    
    return 0;
}