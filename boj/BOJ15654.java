package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654 {
    private static int N;
    private static int M;
    private static int arr[];
    private static boolean isVisited[];
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(arr[i]);
                dfs();
                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private static void dfs() {
        if (list.size() == M) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println("");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    list.add(arr[i]);
                    dfs();
                    isVisited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
