def solution(a, b):
    if b < a:
        a, b = b, a
    nums = [n for n in range(a,b+1)]
    return sum(nums)