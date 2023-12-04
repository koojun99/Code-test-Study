def solution(data, ext, val_ext, sort_by):
    term ={"code":0, "date":1, "maximum":2, "remain": 3}
    result = []
    for d in data:
        if d[term[ext]] < val_ext:
            result.append(d)
    result = sorted(result, key=lambda x: x[term[sort_by]])
    return result