package boj;

import java.util.Scanner;

public class BOJ1110 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp = N;
        int cnt =0;

        while (true) {
            int q = temp / 10;
            int r = temp % 10;
            int sum = q + r;
            temp = r *10 + (sum%10);
            cnt++;
            if(temp == N) break;
        }

        System.out.println(cnt);
    }
}
