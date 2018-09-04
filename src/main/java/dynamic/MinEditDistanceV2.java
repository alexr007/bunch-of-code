package dynamic;

import java.util.*;

public class MinEditDistanceV2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String w1 = in.next();
        String w2 = in.next();

        int N = w1.length();
        int M = w2.length();

        int[][] dp = new int[N + 1][M + 1];

        for(int i = 0; i < M + 1; i++){
            dp[0][i] = i;
        }
        for(int i = 0; i < N + 1; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(w1.charAt(i-1) == w2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }

        System.out.println(dp[N][M]);
    }
}