def solution(n, m):
    answer= []
    gcd = 1
    for i in range(1,n+1):
        if n%i == 0 and m%i == 0:
            gcd = i
    lcm = n*m // gcd
    answer.append(gcd)
    answer.append(lcm)
    return answer