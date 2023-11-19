def solution(keymap, targets):
    char_position={}
    for key in keymap:
        for i, char in enumerate(key):
            if char not in char_position:
                char_position[char] = []
            char_position[char].append(i)
    result = []
    for target in targets:
        total = 0
        for char in target:
            if char not in char_position:
                total = -1
                break
            total += min(char_position[char])+1 if total != -1 else -1
        result.append(total)
    return result