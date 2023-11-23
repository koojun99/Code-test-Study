def solution(t, p):
    count = 0
    for n in range(len(t) - len(p)+1):
        num = int(t[n:n+len(p)])
        if num <= int(p):
            count += 1
    return count