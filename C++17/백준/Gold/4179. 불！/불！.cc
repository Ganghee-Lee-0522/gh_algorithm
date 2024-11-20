#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second

string board[1002];
int dist_f[1002][1002];
int dist_j[1002][1002];

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M;
	queue<pair<int, int>> q_f;
	queue<pair<int, int>> q_j;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		fill(dist_f[i], dist_f[i] + M, -1);
		fill(dist_j[i], dist_j[i] + M, -1);
	}

	for (int i = 0; i < N; i++)
		cin >> board[i];

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 'F') {
				q_f.push({ i, j });
				dist_f[i][j] = 0;
			}
			if (board[i][j] == 'J') {
				q_j.push({ i, j });
				dist_j[i][j] = 0;
			}
		}
	}

	while (!q_f.empty()) {
		pair<int, int> cur = q_f.front();
		q_f.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			if (dist_f[nx][ny] >= 0 || board[nx][ny] == '#')
				continue;

			dist_f[nx][ny] = dist_f[cur.X][cur.Y] + 1;
			q_f.push({ nx, ny });
		}
	}

	while (!q_j.empty()) {
		pair<int, int> cur = q_j.front();
		q_j.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				cout << dist_j[cur.X][cur.Y] + 1;
				return 0;
			}
			if (dist_j[nx][ny] >= 0 || board[nx][ny] == '#')
				continue;
			if (dist_f[nx][ny] != -1 && dist_f[nx][ny] <= dist_j[cur.X][cur.Y] + 1)
				continue;

			dist_j[nx][ny] = dist_j[cur.X][cur.Y] + 1;
			q_j.push({ nx, ny });
		}
	}

	cout << "IMPOSSIBLE";
}
