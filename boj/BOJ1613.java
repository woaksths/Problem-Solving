package boj;

import java.util.Scanner;

public class BOJ1613 {

    private static int history[][];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        history = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            int before = sc.nextInt();
            int after = sc.nextInt();
            history[before][after] = -1;
            history[after][before] = 1;
        }
        floyd(n);

        int s = sc.nextInt();
        while (s > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(history[a][b]);
            s--;
        }
    }

    private static void floyd(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (history[j][i] == -1 && history[i][k] == -1) {
                        history[j][k] = -1;
                        history[k][j] = 1;
                    }
                }
            }
        }
    }
}
