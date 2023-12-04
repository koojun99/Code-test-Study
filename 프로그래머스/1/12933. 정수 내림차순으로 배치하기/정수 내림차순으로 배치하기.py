def solution(n):
    n = str(n)
    num = []
    for i in range(len(n)):
        num.append(n[i])
    num.sort(reverse=True)
    num =''.join(num)
    return int(num)