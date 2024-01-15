def solution(n):
    half = n // 2
    count = 0
    for i in range(1, half+1):
        sum = i
        for j in range(i+1, n+1):
            sum += j
            if sum > n:
                break
            elif sum == n:
                count += 1
    return count+1