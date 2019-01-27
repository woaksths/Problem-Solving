package boj;

import java.util.Scanner;

public class BOJ4344 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int sum = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            float avg = (sum / (float) n);

            int cnt =0;
            for (int j = 0; j < n; j++) {
                if( arr[j] > avg) cnt++;
            }
            float res = cnt/(float)n;
            res = res *100;
            System.out.println(String.format("%,.3f", res) +"%") ;
        }
    }
}
