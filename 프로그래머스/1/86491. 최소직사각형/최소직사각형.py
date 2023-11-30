def solution(sizes):
    width = []
    height = []
    for size in sizes:
        size.sort()
        width.append(size[0])
        height.append(size[1])
    answer = max(width) * max(height)
    return answer