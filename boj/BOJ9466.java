package boj;

import java.util.Scanner;

public class BOJ9466 {

    private static int chk[][] = new int[1005][1005];
    private static char map[][] = new char[1005][1005];
    private static int res = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (chk[i][j] == 0) {
                    dfs(i, j, cnt++);
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int xi, int xj, int f) {
        chk[xi][xj] = f;
        char d = map[xi][xj];
        int nx = xi;
        int ny = xj;

        if (d == 'N') {
            nx = nx - 1;
        }
        if (d == 'W') {
            ny = ny - 1;
        }
        if (d == 'S') {
            nx = nx + 1;
        }
        if (d == 'E') {
            ny = ny + 1;
        }

        if (chk[nx][ny] == 0) {
            dfs(nx, ny, f);
        } else if (chk[nx][ny] == f) {
            res++;
        }
    }
}
