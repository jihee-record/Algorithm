package 백준.백준_6000_6999.백준_6064_카잉달력_S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_6064_카잉달력_S1_132ms {
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long egcd(long a, long b, long[] xy) {
        if (b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }
        long g = egcd(b, a % b, xy);
        long x = xy[0], y = xy[1];
        xy[0] = y;
        xy[1] = x - (a / b) * y;
        return g;
    }

    static long modInverse(long a, long m) {
        long[] xy = new long[2];
        long g = egcd(a, m, xy);
        if (g != 1) return -1;
        return (xy[0] % m + m) % m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long M = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long g = gcd(M, N);
            long l = lcm(M, N);

            long diff = y - x;
            if (diff % g != 0) {
                sb.append(-1).append("\n"); // 해 없음
                continue;
            }

            // (M/g) * k ≡ (y - x)/g  (mod N/g)
            long M2 = M / g;
            long N2 = N / g;
            long diff2 = diff / g;

            long inv = modInverse(M2 % N2, N2);
            if (inv == -1) {
                sb.append(-1).append("\n");
                continue;
            }

            long k = (diff2 % N2 + N2) % N2;
            k = (k * inv) % N2;

            long year = x + M * k;
            if (year > l) year %= l;
            if (year == 0) year = l;

            sb.append(year).append("\n");
        }

        System.out.print(sb);
    }

}
