package boj;

import java.util.ArrayList;
import java.util.Scanner;


public class BOJ15649 {
    private static ArrayList<Integer> list = new ArrayList<>();
    private static boolean isVisited[];
    private static int N;
    private static int M;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(i);
                dfs();
                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private static void dfs() {
        if (list.size() == M) {
            for(int i=0; i<list.size(); i++){
                System.out.print(list.get(i) +" ");
            }
            System.out.println("");
        } else {
            for(int i=1; i<=N; i++){
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    list.add(i);
                    dfs();
                    isVisited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
