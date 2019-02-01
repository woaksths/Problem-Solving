package boj;

import java.util.Scanner;

public class BOJ15954 {
    private static int arr[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        arr = new int[N];
        double result = Double.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i, k = j + K - 1; k < N; k++) {
                result = Math.min(result,solution(j, k));
            }
        }
        System.out.println(result);
    }

    private static double solution(int j, int k) {
        double avg;
        double var = 0;
        double std;
        int sum = 0;

        for (int i = j; i <= k; i++) {
            sum += arr[i];
        }
        avg = sum / (double)(k-j+1);

        for (int i = j; i <= k; i++) {
            var +=(arr[i] - avg) * (arr[i]-avg);
        }
        var = var /(double) (k-j+1);
        std = Math.sqrt(var);
        return std;
    }
}
