package boj;

import java.util.Scanner;

public class BOJ17144 {
    private static int map[][];
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};
    private static int clockWise;
    private static int counterClockWise;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    clockWise = i;
                }
            }
        }
        counterClockWise = clockWise - 1;
        while (T > 0) {
            spreadDust();
            airPurifier();
            T--;
        }
        int result =0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] >0){
                    result += map[i][j];
                }
            }
        }
        System.out.println(result);
    }

    private static void airPurifier() {
        moveClock();
        moveCounterClock();
    }

    private static void moveCounterClock() {
        for (int i = counterClockWise - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < map[0].length; i++) {
            if (i + 1 >= map[0].length) break;
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0, j = map[0].length - 1; i < counterClockWise; i++) {
            map[i][j] = map[i + 1][j];
        }
        for (int i = map[0].length - 1; i > 0; i--) {
            if (i == 1) {
                map[counterClockWise][i] = 0;
            } else {
                map[counterClockWise][i] = map[counterClockWise][i - 1];
            }
        }
    }

    private static void moveClock() {
        for (int i = clockWise; i < map.length; i++) {
            if (i + 1 >= map.length) break;
            map[i][0] = map[i + 1][0];
        }
        map[clockWise][0] = -1;
        for (int j = 0, i = map.length - 1; j < map[0].length; j++) {
            if (j + 1 >= map[0].length) break;
            map[i][j] = map[i][j + 1];
        }
        for (int i = map.length - 1, j = map[0].length - 1; i > clockWise; i--) {
            map[i][j] = map[i - 1][j];
        }
        for (int i = map[0].length - 1; i > 0; i--) {
            if (i == 1) {
                map[clockWise][i] = 0;
            } else {
                map[clockWise][i] = map[clockWise][i - 1];
            }
        }
    }

    private static void spreadDust() {
        int temp[][] = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int currentQuantity = map[i][j];
                if (currentQuantity >= 5) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length ||
                                map[nx][ny] == -1) continue;
                        temp[nx][ny] += (currentQuantity / 5);
                        map[i][j] -= (currentQuantity / 5);
                    }
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] += temp[i][j];
            }
        }
    }
}
