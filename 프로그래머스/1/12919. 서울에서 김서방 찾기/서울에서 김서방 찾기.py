def solution(seoul):
    for name in seoul:
        if name == "Kim":
            return "김서방은 " + str(seoul.index(name)) + "에 있다"
