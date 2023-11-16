def solution(name, yearning, photo):
    score = dict(zip(name, yearning))
    results = []
    for names in photo:
        total = 0
        for friend in names:
            if friend in score:
                total += score[friend]
        results.append(total)
    return results