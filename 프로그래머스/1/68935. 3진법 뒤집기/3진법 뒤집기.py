def solution(n):
    trinary = []
    decimal = 0
    while n:
        trinary.append(str(n%3))
        n //= 3
    num = ''.join(trinary[::-1])
    for i , digit in enumerate(num):
        decimal += int(digit) * (3 ** i )
    return decimal