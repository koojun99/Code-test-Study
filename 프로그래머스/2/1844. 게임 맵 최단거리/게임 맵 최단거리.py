from collections import deque
def solution(maps):
    n, m = len(maps), len(maps[0])
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    queue = deque([(0, 0, 1)])  # (x, y, count)
    visited = set([(0, 0)])

    while queue:
        x, y, count = queue.popleft()
        if x == n - 1 and y == m - 1:
            return count
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1 and (nx, ny) not in visited:
                queue.append((nx, ny, count + 1))
                visited.add((nx, ny))
    return -1