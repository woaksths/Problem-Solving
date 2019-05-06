package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15650 {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static int m;
    private static int n;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dfs(1);
    }

    private static void dfs(int idx) {
        if (list.size() == m) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println("");
        }else {
            for (int i = idx; i <= n; i++) {
                if (list.size() < m) {
                    list.add(i);
                    dfs(i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
