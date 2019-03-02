package boj;

import java.util.Scanner;

public class BOJ1003 {

    private static int arr[][] = new int[41][2];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr[0][0] = 1;
        arr[0][1] = 0;

        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
            arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
        }

        while (N > 0) {
            int n = sc.nextInt();
            System.out.println(arr[n][0] + " " + arr[n][1]);
            N--;
        }
    }
}
