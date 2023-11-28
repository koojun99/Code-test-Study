def solution(X, Y):
    common_set = set(X) & set(Y)
    if not common_set:
        return "-1"

    common = []
    for num in common_set:
        common.extend([num] * min(X.count(num), Y.count(num)))

    common.sort(reverse=True)

    if common[0] == "0":
        return "0"

    return "".join(common)