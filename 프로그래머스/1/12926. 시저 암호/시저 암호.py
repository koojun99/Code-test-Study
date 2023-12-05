def solution(s, n):
    result = []
    for char in s:
        if char.isupper():
            result.append(chr((ord(char) - ord('A') + n) % 26 + ord('A')))
        elif char.islower():
            result.append(chr((ord(char) - ord('a') + n) % 26 + ord('a')))
        else:
            result.append(char)
    return ''.join(result)
