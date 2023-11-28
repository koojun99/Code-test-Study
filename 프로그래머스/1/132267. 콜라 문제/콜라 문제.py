def solution(a, b, n):
    total = 0
    while n >= a:
        exchange = n // a  # 교환할 수 있는 콜라의 수
        total += exchange * b
        n = n % a + exchange * b
    return total