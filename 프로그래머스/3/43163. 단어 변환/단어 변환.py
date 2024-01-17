# def dfs(words, visited, current):
#     visited[current] = True
from collections import deque   
def difference(word1, word2):
    difference = 0
    for i in range(len(word1)):
        if (word1[i] != word2[i]):
            difference += 1
    return difference
            
def solution(begin, target, words):
    if target not in words:
        return 0

    queue = deque([(begin, 0)])
    visited = [False] * len(words)

    while queue:
        current_word, count = queue.popleft()
        if current_word == target:
            return count

        for i in range(len(words)):
            if not visited[i] and difference(current_word, words[i]) == 1:
                visited[i] = True
                queue.append((words[i], count + 1))

    return 0