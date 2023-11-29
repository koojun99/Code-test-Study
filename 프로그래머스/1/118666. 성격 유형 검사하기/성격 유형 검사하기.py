def solution(survey, choices):
    scores = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0}
    type_order = ["RT", "CF", "JM", "AN"]  
    for i, answer in enumerate(survey):
        choice = choices[i]
        if choice < 4:  # 비동의
            scores[answer[0]] += (4 - choice)
        elif choice > 4:  # 동의
            scores[answer[1]] += (choice - 4)

    result = ""
    for types in type_order:
        if scores[types[0]] >= scores[types[1]]:
            result += types[0]
        else:
            result += types[1]

    return result