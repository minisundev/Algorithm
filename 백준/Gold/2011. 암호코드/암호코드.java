import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int n = s.length();

        // 첫 글자가 '0'이면 해석 불가
        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        long[] dp = new long[n+1];
        dp[0] = 1; // 아무것도 해석하지 않은 경우 1가지
        dp[1] = 1; // 첫 글자는 0이 아니므로 무조건 1가지 해석 방법

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));     // 마지막 한자리
            int twoDigit = Integer.parseInt(s.substring(i-2, i));     // 마지막 두자리

            // 한 자리 해석(1~9)
            if (oneDigit>0) {
                dp[i] += dp[i-1];
            }

            // 두 자리 해석(10~26)
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }

            dp[i] %= 1000000; // 문제 조건에 따른 모듈러 연산
        }

        System.out.println(dp[n] % 1000000);
    }
}
