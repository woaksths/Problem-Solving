package boj;

import java.util.Scanner;

public class BOJ2512 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int budget[] = new int[N];

        for (int i = 0; i < N; i++) {
            budget[i] = sc.nextInt();
        }
        int maxVal = sc.nextInt();
        int sum = 0;
        int maxBudget = 0;

        for (int i = 0; i < N; i++) {
            maxBudget = Math.max(maxBudget, budget[i]);
            sum += budget[i];
        }
        if (sum <= maxVal) {
            System.out.println(maxBudget);
        } else {

            int start = 0;
            int end = maxBudget;
            int result = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int temp = 0;

                for (int i = 0; i < budget.length; i++) {
                    if (mid <= budget[i]) {
                        temp += mid;
                    } else {
                        temp += budget[i];
                    }
                }
                if (temp <= maxVal) {
                    result = Math.max(mid, result);
                }
                if (temp < maxVal) {
                    start = mid + 1;
                } else if (temp > maxVal) {
                    end = mid - 1;
                } else if (temp == maxVal) {
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
