package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15652 {
    private static int N;
    private static int M;
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            list.add(i);
            dfs(i);
            list.remove(list.size() - 1);
        }
    }

    private static void dfs(int idx) {
        if (list.size() == M) {
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println("");
        } else {
            for(int i= idx; i<=N; i++){
                list.add(i);
                dfs(i);
                list.remove(list.size()-1);
            }
        }
    }
}
