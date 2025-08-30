package 백준.백준_11000_11999.백준_11664_선분과점_G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11664_선분과점_G4_124ms {

    // 거리^2
    static double squareD(double[][] coordi, int A, int B) {
    	double dx = coordi[A][0] - coordi[B][0];
    	double dy = coordi[A][1] - coordi[B][1];
    	double dz = coordi[A][2] - coordi[B][2];
        return dx * dx + dy * dy + dz * dz;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // coordi[0] = A(x1,y1,z1)
        // coordi[1] = B(x2,y2,z2)
        // coordi[2] = C(x0,y0,z0)
        double[][] coordi = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                coordi[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        double[] AB = {coordi[1][0] - coordi[0][0], coordi[1][1] - coordi[0][1], coordi[1][2] - coordi[0][2]};
        double[] AC = {coordi[2][0] - coordi[0][0], coordi[2][1] - coordi[0][1], coordi[2][2] - coordi[0][2]};
//        double[] BC = {coordi[2][0] - coordi[1][0], coordi[2][1] - coordi[1][1], coordi[2][2] - coordi[1][2]};

        // AC·AB
        double dotACAB = AB[0] * AC[0] + AB[1] * AC[1] + AB[2] * AC[2];
        // |AB|^2
        double dotABAB = AB[0] * AB[0] + AB[1] * AB[1] + AB[2] * AB[2];

        // (AC·AB) / (AB·AB)
        // 0 <= t <= 1 : 선분 위, <0이면 A쪽 바깥, >1이면 B쪽 바깥
        double t = (double) dotACAB / dotABAB;

        double distance;
        if (t < 0) {
            distance = Math.sqrt(squareD(coordi, 0, 2));
        } else if (t > 1) {
            distance = Math.sqrt(squareD(coordi, 1, 2));
        } else {
            // 선분 위
            // |AB × AC| / |AB|
        	double crossX = AB[1] * AC[2] - AB[2] * AC[1];
        	double crossY = AB[2] * AC[0] - AB[0] * AC[2];
        	double crossZ = AB[0] * AC[1] - AB[1] * AC[0];
            double crossLen = Math.sqrt(crossX * crossX + crossY * crossY + crossZ * crossZ);
            double abLen = Math.sqrt(dotABAB);
            distance = crossLen / abLen;
        }

        System.out.printf("%.10f\n", distance);
    }
}
