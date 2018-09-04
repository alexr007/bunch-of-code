package dynamic;

import java.util.*;

public class CountRecoding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String number = in.next();
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = number.charAt(0) != '0' ? 1 : 0;
        for(int i =2; i <= N; i++){
            int first = Integer.valueOf(number.substring(i-1, i));
            int second = Integer.valueOf(number.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        System.out.println(dp[N]);
    }

}