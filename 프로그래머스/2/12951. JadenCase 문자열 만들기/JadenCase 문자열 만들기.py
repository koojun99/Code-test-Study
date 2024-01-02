def solution(s):
    words = s.split(" ")
    jadenCase = [word[0].upper() + word[1:].lower() if word else '' for word in words]
    
    return ' '.join(jadenCase)