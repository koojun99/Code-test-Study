def solution(n):
    square_root = n**0.5
    if square_root == int(square_root):
        return (square_root + 1) ** 2
    else:
        return -1
