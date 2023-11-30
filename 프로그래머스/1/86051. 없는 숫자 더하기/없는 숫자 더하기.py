def solution(numbers):
    total = 45
    for number in numbers:
        total -= number
    return total