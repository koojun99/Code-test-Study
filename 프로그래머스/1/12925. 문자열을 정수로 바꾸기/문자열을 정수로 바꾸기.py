def solution(s):
    if s[0] == "-":
        return int(s)
    elif s[0] == "+":
        num = s[1:]
        return int(num)
    return int(s)