def solution(cards1, cards2, goal):
    words1 = {word: idx for idx, word in enumerate(cards1)}
    words2 = {word: idx for idx, word in enumerate(cards2)}
    last_index1, last_index2 = -1, -1
    for word in goal:
        if word in words1:
            if words1[word] <= last_index1 or words1[word] > (last_index1 + 1):
                return "No"
            last_index1 = words1[word]
        elif word in words2:
            if words2[word] <= last_index2 or words2[word] > (last_index2 + 1):
                return "No"
            last_index2 = words2[word]
        else:
            return "No"
    return "Yes"
            