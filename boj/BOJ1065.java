package boj;

import java.util.Scanner;

public class BOJ1065 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(bruteForce(N));
    }

    private static int bruteForce(int n) {
        int cnt = 0;

        for (int i = n; i > 0; i--) {
            String s = String.valueOf(i);
            boolean check = true;
            int diff = 0;

            for (int j = 0; j < s.length(); j++) {
                if (j + 1 >= s.length()) continue;
                if (j == 0) {
                    diff = s.charAt(j) - s.charAt(j + 1);
                    continue;
                }
                if (diff == s.charAt(j) - s.charAt(j + 1)) {
                    diff = s.charAt(j) - s.charAt(j + 1);
                } else {
                    check = false;
                    break;
                }
            }
            if (check) {
                cnt++;
            }
        }
        return cnt;
    }
}
