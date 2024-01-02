package dp.string;

import java.util.Arrays;

//Brute :
//time : O(2^n * n)
//space : O(1)

public class LengthOfLongestIncreasingSubsequence {

	// time : O(n^2)
	// space : O(n)
	public int lenOfLIS(int[] nums) {

		if (nums.length == 0)
			return 0;
		int n = nums.length;

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[i] < (dp[j] + 1))
					dp[i] = (dp[j] + 1);
			}
		}
		return Arrays.stream(dp).max().getAsInt();
	}

}
