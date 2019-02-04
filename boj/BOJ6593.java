package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BOJ6593 {
    private static int x[] = {-1, 1, 0, 0, 0, 0};
    private static int y[] = {0, 0, -1, 1, 0, 0};
    private static int z[] = {0, 0, 0, 0, 1, -1};
    private static char map[][][];
    private static boolean visited[][][];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            int L = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) break;
            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            Building start = new Building(0, 0, 0, 0);
            Building end = new Building(0, 0, 0, 0);

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = sc.next();
                    for (int k = 0; k < s.length(); k++) {
                        map[i][j][k] = s.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start.z = i;
                            start.x = j;
                            start.y = k;
                            start.time = 0;
                        }
                        if (map[i][j][k] == 'E') {
                            end.z = i;
                            end.x = j;
                            end.y = k;
                            end.time = 0;
                        }
                    }
                }
            }
            Queue<Building> queue = new LinkedList<>();
            queue.add(start);
            int result = 0;

            while (!queue.isEmpty()) {
                Building curr = queue.poll();
                visited[curr.z][curr.x][curr.y] = true;

                if (result != 0) break;
                for (int i = 0; i < x.length; i++) {
                    int nx = curr.x + x[i];
                    int ny = curr.y + y[i];
                    int nz = curr.z + z[i];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= map[0].length ||
                            ny >= map[0][0].length || nz >= map.length) continue;

                    if (map[nz][nx][ny] == 'E') {
                        visited[nz][nx][ny] = true;
                        result = curr.time + 1;
                    }

                    if (map[nz][nx][ny] == '.' && !visited[nz][nx][ny]) {
                        visited[nz][nx][ny] = true;
                        queue.add(new Building(nz, nx, ny, curr.time + 1));
                    }
                }
            }
            if (result == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + (result) + " minute(s).");
            }
        }
    }

    static class Building {
        private int x;
        private int y;
        private int z;
        private int time;

        public Building(int z, int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
}
