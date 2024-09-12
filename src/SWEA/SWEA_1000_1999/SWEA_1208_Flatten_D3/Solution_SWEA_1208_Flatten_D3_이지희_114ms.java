package SWEA.SWEA_1000_1999.SWEA_1208_Flatten_D3;

import java.io.*;
import java.util.*;
 
public class Solution_SWEA_1208_Flatten_D3_이지희_114ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
 
            int[] boxes = new int[100];
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }
 
            // 초기 정렬
            Arrays.sort(boxes);
 
            for (int n = 0; n < N; n++) {
                // 최소값 증가, 최대값 감소
                boxes[0]++;
                boxes[99]--;
                // 증가/감소 후 정렬
                int i = 0;
                while (i < 99 && boxes[i] > boxes[i + 1]) {
                    int temp = boxes[i];
                    boxes[i] = boxes[i + 1];
                    boxes[i + 1] = temp;
                    i++;
                }
                int j = 99;
                while (j > 0 && boxes[j] < boxes[j - 1]) {
                    int temp = boxes[j];
                    boxes[j] = boxes[j - 1];
                    boxes[j - 1] = temp;
                    j--;
                }
            }
 
            System.out.println("#" + t + " " + (boxes[99] - boxes[0]));
        }
        br.close();
    }
}