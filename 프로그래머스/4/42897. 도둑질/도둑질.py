def rob(money):
    houses = len(money)
    
    dp = [0]*houses
    dp[0] = money[0]
    dp[1] = max(money[0], money[1])
    
    for i in range(2, houses):
        dp[i] = max(dp[i-1], money[i] + dp[i-2])
    return dp[-1]

def solution(money):
    case1 = rob(money[1:])
    case2 = rob(money[:-1])
    return max(case1, case2)