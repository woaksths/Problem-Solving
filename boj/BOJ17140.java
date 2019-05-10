package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ17140 {
    private static int map[][] = new int[101][101];
    private static int curR;
    private static int curC;
    private static int maxLen;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        curR = 3;
        curC = 3;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int time = 0;

        while (true) {
            if (map[r][c] == k) break;
            maxLen = 0;
            if (curR >= curC) {
                rowCalculation();
                curC = maxLen;
            } else {
                colCalculation();
                curR = maxLen;
            }
            if(time >100){
                time= -1;
                break;
            }
            time++;
        }
        System.out.println(time);
    }

    private static void colCalculation() {
        for (int i = 1; i <= curC; i++) {
            int arr[] = new int[101];
            ArrayList<Info> list = new ArrayList<>();
            for (int j = 1; j <= curR; j++) {
                if (map[j][i] == 0) continue;
                int num = map[j][i];
                arr[num]++;
            }
            for (int j = 1; j <= 100; j++) {
                if (arr[j] > 0) {
                    list.add(new Info(j, arr[j]));
                }
            }
            Collections.sort(list, new Comparator<Info>() {
                @Override
                public int compare(Info o1, Info o2) {
                    return o1.cnt < o2.cnt ? -1 : 1;
                }
            });
            for (int j = 0; j < list.size(); j++) {
                map[2 * j + 1][i] = list.get(j).num;
                map[2 * j + 2][i] = list.get(j).cnt;
            }
            for (int j = list.size() * 2 + 1; j <= 100; j++) {
                map[j][i] = 0;
            }
            if (list.size() * 2 > maxLen) {
                maxLen = list.size() * 2;
            }
        }
    }

    private static void rowCalculation() {
        for (int i = 1; i <= curR; i++) {
            int arr[] = new int[101];
            ArrayList<Info> list = new ArrayList<>();
            for (int j = 1; j <= curC; j++) {
                if (map[i][j] == 0) continue;
                int num = map[i][j];
                arr[num]++;
            }
            for (int j = 1; j <= 100; j++) {
                if (arr[j] > 0) {
                    list.add(new Info(j, arr[j]));
                }
            }
            Collections.sort(list, new Comparator<Info>() {
                @Override
                public int compare(Info o1, Info o2) {
                    return o1.cnt < o2.cnt ? -1 : 1;
                }
            });
            for (int j = 0; j < list.size(); j++) {
                map[i][2 * j + 1] = list.get(j).num;
                map[i][2 * j + 2] = list.get(j).cnt;
            }
            for (int j = list.size() * 2 + 1; j <= 100; j++) {
                map[i][j] = 0;
            }
            if (list.size() * 2 > maxLen) {
                maxLen = list.size() * 2;
            }
        }
        return;
    }


    static class Info {
        private int num;
        private int cnt;

        public Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}