package SWEA.SWEA_2000_2999.SWEA_2063_중간값찾기_D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_2063_중간값찾기_D1_이지희_103ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] scores = new int[N];
        for(int n=0; n<N; n++) {
            scores[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores);

        System.out.println(scores[N/2]);

        br.close();
    }
}