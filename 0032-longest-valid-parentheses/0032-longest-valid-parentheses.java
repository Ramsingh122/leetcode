class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int prev = i - dp[i - 1] - 1;
                    if (prev >= 0 && s.charAt(prev) == '(') {
                        dp[i] = dp[i - 1] + 2 + (prev >= 1 ? dp[prev - 1] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}