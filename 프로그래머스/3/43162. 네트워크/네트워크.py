def dfs(computers, visited, current):
    visited[current] = True
    for i in range(len(computers)):
        if computers[current][i] == 1 and not visited[i]:
            dfs(computers, visited, i)

def solution(n, computers):
    visited = [False] * n
    network_count = 0

    for i in range(n):
        if not visited[i]:
            dfs(computers, visited, i)
            network_count += 1

    return network_count
