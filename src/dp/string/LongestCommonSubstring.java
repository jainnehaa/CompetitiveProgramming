package dp.string;

public class LongestCommonSubstring {

	// brute-force
	// time : O(n^2 * m)
	// space : O(1)

	// time : O(n*m)
	// space : O(n*m)
	public static int lenOfLCS(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[m + 1][n + 1];
		int maxLen = 0;
		int endIndex = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > maxLen)
						endIndex = i - 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}
		if (maxLen == 0) {
			System.out.println("No Longest Common Substring : " + str1.substring(endIndex - maxLen + 1, endIndex + 1));
		}
		System.out.println("Longest Common Substring : " + str1.substring(endIndex - maxLen + 1, endIndex + 1));
		// System.out.println(Arrays.deepToString(dp));
		return maxLen;
	}

	// time : O(n*m)
	// space : O(n)
	public static int lenOfLCSSpaceOptimized(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[2][n + 1];
		int maxLen = 0;
		int endIndex = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
					if (dp[i % 2][j] > maxLen)
						endIndex = i - 1;
					maxLen = Math.max(maxLen, dp[i % 2][j]);
				} else {
					dp[i % 2][j] = 0;
				}
//				System.out.println("match");
//				System.out.println("i: " + i + ", j: " + j + ", maxLen : "+ maxLen+ ", dp : " + Arrays.deepToString(dp));
			}
		}
		if (maxLen == 0) {
			System.out.println("No Longest Common Substring : " + str1.substring(endIndex - maxLen + 1, endIndex + 1));
		}
		System.out.println("Longest Common Substring : " + str1.substring(endIndex - maxLen + 1, endIndex + 1));
		return maxLen;
	}

	public static void main(String[] args) {
		String str1 = "opengenus";
		String str2 = "genius";
		int maxLen = lenOfLCS(str1, str2);
		System.out.println(maxLen);

		maxLen = lenOfLCSSpaceOptimized(str1, str2);
		System.out.println(maxLen);
	}
}