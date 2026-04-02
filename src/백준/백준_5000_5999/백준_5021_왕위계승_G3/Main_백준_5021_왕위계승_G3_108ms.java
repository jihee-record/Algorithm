package 백준.백준_5000_5999.백준_5021_왕위계승_G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_5021_왕위계승_G3_108ms {
    static class Royal {
        String name;
        String p1, p2;
        double blood;

        Royal(String name) {
            this.name = name;
            this.p1 = null;
            this.p2 = null;
            this.blood = -1.0;
        }
    }

    static HashMap<String, Royal> map = new HashMap<>();
    static String primo;

    static double dfs(String name) {
        Royal now = map.get(name);
        if (now == null) return 0.0;

        if (now.blood != -1.0) return now.blood;

        if (name.equals(primo)) {
            now.blood = 1.0;
            return 1.0;
        }

        now.blood = (dfs(now.p1) + dfs(now.p2)) / 2.0;
        return now.blood;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        primo = br.readLine();

        Royal first = new Royal(primo);
        first.blood = 1.0;
        map.put(primo, first);

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            Royal c = map.computeIfAbsent(child, k -> new Royal(k));
            c.p1 = p1;
            c.p2 = p2;

            map.computeIfAbsent(p1, k -> new Royal(k));
            map.computeIfAbsent(p2, k -> new Royal(k));
        }

        String successor = "";
        double maxBlood = -1.0;

        for (int m = 0; m < M; m++) {
            String candidate = br.readLine();
            double blood = dfs(candidate);

            if (blood > maxBlood) {
                maxBlood = blood;
                successor = candidate;
            }
        }

        System.out.println(successor);
        br.close();
    }
}