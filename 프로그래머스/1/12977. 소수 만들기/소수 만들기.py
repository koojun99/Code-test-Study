from itertools import combinations
def solution(nums):
    nums.sort()
    count = 0
    possible = list(combinations(nums, 3))
    for num in possible:
        if is_prime(sum(num)):
            count += 1
    return count
def is_prime(num):
    """주어진 숫자가 소수인지 판별하는 함수"""
    if num <= 1:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True