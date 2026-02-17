package 프로그래머스.java.PCCP.모의_1회.ROUND3;

class Solution {
    static String mix = "Rr";
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        
        int N = 0;
        for(int i=0; i<queries.length; i++){
           N = Math.max(N, queries[i][0]); // 가장 큰 세대
        }

        int leafN = (int)Math.pow(4, N - 1);

        String[][] peas = new String[N + 1][leafN + 1];
        peas[1][1] = "Rr";

        for(int n=1; n<N; n++){
            int P = (int)Math.pow(4, n-1);
            for(int p=1; p<=P; p++){
                int last = 4 * p;
                switch(peas[n][p]){
                case "Rr":
                    peas[n+1][last] = "rr";
                    peas[n+1][last - 1] = "Rr";
                    peas[n+1][last - 2] = "Rr";
                    peas[n+1][last - 3] = "RR";
                break;
                case "RR":
                    peas[n+1][last] = "RR";
                    peas[n+1][last - 1] = "RR";
                    peas[n+1][last - 2] = "RR";
                    peas[n+1][last - 3] = "RR";
                    break;
                case "rr":
                    peas[n+1][last] = "rr";
                    peas[n+1][last - 1] = "rr";
                    peas[n+1][last - 2] = "rr";
                    peas[n+1][last - 3] = "rr";
                    break;
                }
            }
        }

        for(int i=0; i<queries.length; i++){
            int n = queries[i][0];
            int p = queries[i][1];
            answer[i] = peas[n][p];
        }
        
        return answer;
    }
}