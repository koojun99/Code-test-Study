def solution(triangle):
    height = len(triangle)
    dp = [[0 for _ in range(i+1)] for i in range(height)]
    dp[0][0] = triangle[0][0]
    
    for i in range(1, height):
        for j in range(i+1):
            left = dp[i-1][j-1] if j > 0 else 0
            right = dp[i-1][j] if j < i else 0
            
            dp[i][j] = max(left, right) + triangle[i][j]
            
    return max(dp[-1])