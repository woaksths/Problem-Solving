package boj;

import java.util.Scanner;

public class BOJ17143 {

    private static int map[][];
    private static int result = 0;
    private static Shark[] shark;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        map = new int[R + 1][C + 1];
        int M = sc.nextInt();
        shark = new Shark[M + 1];

        for (int i = 1; i <= M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            shark[i] = new Shark(r, c, s, d - 1, z, true);
            map[r][c] = i;
        }

        for (int i = 1; i < map[0].length; i++) {
            fishShark(i);
            moveShark();
        }
        System.out.println(result);
    }

    private static void moveShark() {
        int temp[][] = new int[map.length][map[0].length];
        for (int i = 1; i < shark.length; i++) {
            if (shark[i].isSurvived) {
                int dir = shark[i].d;
                int curX = shark[i].r;
                int curY = shark[i].c;
                int nx = curX;
                int ny = curY;
                int s = shark[i].s;
                map[curX][curY] = 0;

                for (int j = 1; j <= s; j++) {
                    if (dir == 0) {
                        if (nx == 1) {
                            nx += 1;
                            dir = 1;
                            continue;
                        } else {
                            nx -= 1;
                        }
                    } else if (dir == 1) {
                        if (nx == map.length - 1) {
                            nx -= 1;
                            dir = 0;
                            continue;
                        } else {
                            nx += 1;
                        }
                    } else if (dir == 2) {
                        if (ny == map[0].length - 1) {
                            ny -= 1;
                            dir = 3;
                            continue;
                        } else {
                            ny += 1;
                        }
                    } else if (dir == 3) {
                        if (ny == 1) {
                            ny += 1;
                            dir = 2;
                            continue;
                        } else {
                            ny -= 1;
                        }
                    }
                }
                shark[i].r = nx;
                shark[i].c = ny;
                shark[i].d = dir;
                if (temp[nx][ny] > 0) {
                    if (shark[i].z > shark[temp[nx][ny]].z) {
                        shark[temp[nx][ny]].isSurvived = false;
                        temp[nx][ny] = i;
                    } else {
                        shark[i].isSurvived = false;
                    }
                } else {
                    temp[nx][ny] = i;
                }
            }

        }
        map = temp;
    }

    private static void fishShark(int col) {
        for (int i = 1; i < map.length; i++) {
            if (map[i][col] > 0) {
                int sharkIdx = map[i][col];
                shark[sharkIdx].isSurvived = false;
                result += shark[sharkIdx].z;
                map[i][col] = 0;
                break;
            }
        }
    }

    static class Shark {
        private int r;
        private int c;
        private int s;
        private int d;
        private int z;
        private boolean isSurvived;

        public Shark(int r, int c, int s, int d, int z, boolean isSurvived) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.isSurvived = isSurvived;
        }
    }
}
