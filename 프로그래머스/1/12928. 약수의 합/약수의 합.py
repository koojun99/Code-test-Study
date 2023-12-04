def solution(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    divider = [1,n]
    for i in range(2, n):
        if n%i == 0:
            divider.append(i)
    
    return sum(divider)