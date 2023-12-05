def solution(s):
    if not (len(s) == 4 or len(s) == 6):
        return False
    for char in s:
        if not char.isdigit():
            return False
    return True
        
    